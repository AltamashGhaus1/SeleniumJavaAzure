package com.jdbc.automation.executor.AA_Clone_70_Users.AdvanceAnalytics;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Test_70_Users {

    private static final Logger log= LoggerFactory.getLogger(Test_70_Users.class);

        public static void main(String args[]) {

            Date startTime = null;
            DateTimeZone dtZone = null;
            DateTime startDtus = null;
            try {
                try {
                    Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("KILLED");
                startTime = Calendar.getInstance().getTime();
                dtZone = DateTimeZone.forID("Asia/Kolkata");
                DateTime startDate = new DateTime(startTime);
                startDtus = startDate.withZone(dtZone);

                // Number of WebDriver instances
                int numDrivers = 1;

                // Create a thread pool with the desired number of threads
                ExecutorService executor = Executors.newFixedThreadPool(numDrivers);


                // Submit tasks to the executor
                for (int i = 0; i < numDrivers; i++) {

                    executor.submit(new MyWebDriverRunnable());
                }

                // Shutdown the executor after all tasks are completed

                try{
                executor.shutdown();
            }
                catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
}
