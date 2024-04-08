package com.example.sportevents_betting.core.services.logger;

import com.example.sportevents_betting.api.inputoutput.log.add.AddLogInput;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOperation;
import com.example.sportevents_betting.api.inputoutput.log.add.AddLogOutput;
import com.example.sportevents_betting.persistence.entities.InternalLogger;
import com.example.sportevents_betting.persistence.repositories.InternalLoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddLogOperationProcessor implements AddLogOperation {

    private final InternalLoggerRepository internalLoggerRepository;

    @Override
    public AddLogOutput process(AddLogInput input) {
        InternalLogger log = InternalLogger.builder()
                .logMessage(input.getLogMessage())
                .build();

        internalLoggerRepository.save(log);

        return AddLogOutput.builder()
                .id(log.getId().toString())
                .logMessage(log.getLogMessage())
                .timestamp(log.getTimestamp().toString())
                .build();
    }
}
