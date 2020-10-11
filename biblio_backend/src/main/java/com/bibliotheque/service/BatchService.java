package com.bibliotheque.service;

import org.springframework.stereotype.Service;

@Service
public interface BatchService {
    void refreshReservation();
}
