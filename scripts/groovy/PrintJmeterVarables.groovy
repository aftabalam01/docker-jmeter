
//Usefull to print variable before test for debugging

import java.util.Map;

String jMeterVars;
jMeterVars = "Quantity of variables: " + vars.entrySet().size() + ".\n\n";
jMeterVars += "[VARIABLE NAME]      ==>>      [VARIABLE VALUE]\n\n";
for (Map.Entry entry : vars.entrySet()) {
    jMeterVars += entry.getKey() + "  ==>>  " + entry.getValue().toString() + "\n";
    }
    try {
        log.info("List of Variables are: \n\n");
        log.info(jMeterVars);
        } catch(Exception e) {
            System.err.println("IOException: " + e.getMessage());
            }
