package com.equipobeta.friendzone.service;
import com.equipobeta.friendzone.events.Event;
import com.equipobeta.friendzone.events.EventController;

import com.equipobeta.friendzone.events.EventRepository;
import com.equipobeta.friendzone.events.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EventServiceTest {
    @Mock
    private EventRepository eventRepositoryMock;

    private EventService eventServiceUnderTest;

    @BeforeEach
    void setUp() {
        eventServiceUnderTest = new EventService(eventRepositoryMock);
    }

    @Test
    void  getAllEventsTest() {
        //When
        eventServiceUnderTest.getAllEvents();
        // Then
        verify(eventRepositoryMock).findAll();
    }


    @Test
    void deletebyIdTest() {
        //When
        eventServiceUnderTest.deleteById(1L);

        ArgumentCaptor<Long> deleteIdArgumenCaptor = ArgumentCaptor.forClass(Long.class);
        // Then
        verify(eventRepositoryMock).deleteById(deleteIdArgumenCaptor.capture());

        Long caputredEventId = deleteIdArgumenCaptor.getValue();

        assertThat(caputredEventId).isEqualTo(1L);
    }



}
