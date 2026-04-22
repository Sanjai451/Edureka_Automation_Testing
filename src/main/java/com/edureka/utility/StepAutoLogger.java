package com.edureka.utility;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.TestStepStarted;

/**
 * Cucumber plugin that auto-logs every step into ExtentReport.
 * No need to write logs.log() in any step definition.
 * Register in RunnerIO: plugins = {"com.edureka.utility.StepAutoLogger"}
 */
public class StepAutoLogger implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        // Fires BEFORE each step — logs step name as INFO
        publisher.registerHandlerFor(TestStepStarted.class, event -> {
            if (!(event.getTestStep() instanceof PickleStepTestStep)) return;

            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
            String stepText = step.getStep().getText();

            ExtentTest test = ExtentReportManager.getTest();
            if (test != null) {
                test.log(Status.INFO, "Step: " + stepText);
            }
        });

        // Fires AFTER each step — logs PASS or FAIL with reason
        publisher.registerHandlerFor(TestStepFinished.class, event -> {
            if (!(event.getTestStep() instanceof PickleStepTestStep)) return;

            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
            String stepText     = step.getStep().getText();
            io.cucumber.plugin.event.Status stepStatus = event.getResult().getStatus();
            Throwable error = event.getResult().getError();

            ExtentTest test = ExtentReportManager.getTest();
            if (test == null) return;

            switch (stepStatus) {
                case PASSED:
                    test.log(Status.PASS, "Passed: " + stepText);
                    break;
                case FAILED:
                    String reason = (error != null) ? error.getMessage() : "Unknown failure";
                    test.log(Status.FAIL, "Failed: " + stepText + " — " + reason);
                    break;
                case SKIPPED:
                case PENDING:
                    test.log(Status.SKIP, "Skipped: " + stepText);
                    break;
                default:
                    test.log(Status.INFO, "? " + stepStatus + ": " + stepText);
            }
        });
    }
}