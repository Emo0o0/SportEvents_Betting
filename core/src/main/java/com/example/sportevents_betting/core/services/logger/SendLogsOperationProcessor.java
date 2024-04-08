package com.example.sportevents_betting.core.services.logger;

import com.example.sportevents_betting.api.inputoutput.log.send.SendLogsInput;
import com.example.sportevents_betting.api.inputoutput.log.send.SendLogsOperation;
import com.example.sportevents_betting.api.inputoutput.log.send.SendLogsOutput;
import com.example.sportevents_betting.core.exceptions.logger.InternalLoggerIsEmptyException;
import com.example.sportevents_betting.persistence.entities.InternalLogger;
import com.example.sportevents_betting.persistence.repositories.InternalLoggerRepository;
import com.example.sportevents_logger.api.inputoutput.receiveevents.LoggerReceiveEventsInput;
import com.example.sportevents_logger.api.inputoutput.receiveevents.LoggerReceiveEventsListInput;
import com.example.sportevents_logger.restexport.SportEventsLoggerRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SendLogsOperationProcessor implements SendLogsOperation {

    private final InternalLoggerRepository internalLoggerRepository;
    private final SportEventsLoggerRestClient sportEventsLoggerRestClient;

    @Override
    public SendLogsOutput process(SendLogsInput input) {
        if (internalLoggerRepository.findAll().isEmpty())
            throw new InternalLoggerIsEmptyException("Logger is empty");

        List<InternalLogger> internalLogs = internalLoggerRepository.findAll();

        Set<LoggerReceiveEventsInput> listOfLogs = new HashSet<>();
        for (InternalLogger il : internalLogs) {

            LoggerReceiveEventsInput log = LoggerReceiveEventsInput.builder()
                    .logMessage(il.getLogMessage())
                    .timestamp(il.getTimestamp())
                    .build();
            listOfLogs.add(log);
        }

        sportEventsLoggerRestClient.receiveEvents(LoggerReceiveEventsListInput.builder()
                .receivedLogs(listOfLogs)
                .build());

        internalLoggerRepository.deleteAll();

        return new SendLogsOutput();
    }
}
