package com.equipobeta.friendzone.events;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)

class EventServiceTest {
    @Mock private EventRepository eventRepositoryMock;
    private EventService eventServiceUnderTest;


    @BeforeEach
     void setUp() {
        eventServiceUnderTest = new EventService(eventRepositoryMock);
    }

    @Test
    void getAllEvents() {
        //When
        eventServiceUnderTest.getAllEvents();

        //Then
        verify(eventRepositoryMock).findAll();
    }

    @Test
    void findById() {
        //When
        eventServiceUnderTest.findById(1L);

        //esta clase me permite capturar los argumentos
        ArgumentCaptor<Long> eventIdArgumentCaptor = ArgumentCaptor.forClass(long.class);

        //Then
        verify(eventRepositoryMock).findById(eventIdArgumentCaptor.capture());

        Long capturedEventId = eventIdArgumentCaptor.getValue();

        assertThat(capturedEventId).isEqualTo(1L);
    }

    @Test
    void createEvent() {
        //Give
        Event event = new Event(
                1L, "Thor: Love and Thunder",
                "Sol, Madrid",
                "El Dios del Trueno (Chris Hemsworth) emprende un viaje que no se parece en nada a lo que se ha enfrentado hasta ahora: una búsqueda de la paz interior. Pero el retiro de Thor se ve interrumpido por un asesino galáctico conocido como Gorr el Carnicero de Dioses (Christian Bale), que busca la extinción de los dioses. Para hacer frente a la amenaza, Thor solicita la ayuda del Rey Valkiria (Tessa Thompson), de Korg (Taika Waititi) y de su ex novia Jane Foster (Natalie Portman) que, para sorpresa de Thor, empuña inexplicablemente su martillo mágico, Mjolnir, como la Poderosa Thor. Juntos, se embarcan en una aventura cósmica en la que tendrán que descubrir el misterio de la venganza del Carnicero de Dioses y detenerlo antes de que sea demasiado tarde.",
                "https://lumiere-a.akamaihd.net/v1/images/image_06aa7fbd.jpeg?region=0%2C0%2C540%2C810",
                "14 €",
                "23:30 h",
                "28 de julio",
                "Jesus, Bea, Ana, Carlos, Miguel"
        );

        Mockito.when(eventServiceUnderTest.createEvent(event)).thenReturn(event);

        //When
        Event eventActual = eventServiceUnderTest.createEvent(event);
        ArgumentCaptor<Event> eventArgumentCaptor = ArgumentCaptor.forClass(Event.class);

        //Then
        verify(eventRepositoryMock).save(eventArgumentCaptor.capture());

        Event capturedEvent = eventArgumentCaptor.getValue();

        assertThat(capturedEvent).isEqualTo(event);

        assertThat(eventActual).isEqualTo(event);
    }

    @Test
    void  update() {
        //Give
        Event event = new Event(
                1L,
                "Thor: Love and Thunder",
                "Location",
                "El Dios del Trueno emprende un viaje que no se parece en nada a",
                "https://lumiere-a.akamaihd.net/v1/images/image_06aa7fbd.jpeg?region=0%2C0%2C540%2C810",
                "14 €",
                "23:30 h",
                "28 de julio",
                "Jesus, Bea, Ana, Carlos, Miguel"
                );
        Mockito.when(eventServiceUnderTest.update(event)).thenReturn(event);

        Event eventUpdated = eventServiceUnderTest.update(event);
        ArgumentCaptor<Event> eventArgumentCaptor = ArgumentCaptor.forClass(Event.class);
        verify(eventRepositoryMock).save(eventArgumentCaptor.capture());
        Event capturedEvent = eventArgumentCaptor.getValue();
        assertThat(capturedEvent).isEqualTo(event);
        assertThat(eventUpdated).isEqualTo(event);
    }

    @Test
    void deleteById(){
        //Give
        Event event = new Event(
                1L,
                "Thor: Love and Thunder",
                "Location",
                "El Dios del Trueno emprende un viaje que no se parece en nada a",
                "https://lumiere-a.akamaihd.net/v1/images/image_06aa7fbd.jpeg?region=0%2C0%2C540%2C810",
                "14 €",
                "23:30 h",
                "28 de julio",
                "Jesus, Bea, Ana, Carlos, Miguel"
        );
        //eventServiceUnderTest.createEvent(event);
        eventServiceUnderTest.deleteById(event.getId());
        verify(eventRepositoryMock).deleteById(event.getId());
    }




}