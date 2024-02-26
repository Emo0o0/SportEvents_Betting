package com.example.sportevents_betting.api.base;

public interface OperationProcessor<Input extends OperationInput, Response extends OperationResult> {

    Response process(Input input);

}
