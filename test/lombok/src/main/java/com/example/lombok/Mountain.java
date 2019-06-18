package com.example.lombok;
/*
The Jetbrains IntelliJ IDEA editor is compatible with lombok.
1)
Preferences | Build, Execution, Deployment | Compiler | Annotation Processors
Enable annotation processing box is checked
Obtain processors from project classpath option is selected
2)
Add the Lombok IntelliJ plugin to add lombok support for IntelliJ:
Preferences | Plugins, open the Marketplace tab
Search for Lombok Plugin by Michail Plushnikov
Click on Install plugin
Restart IntelliJ IDEA
 */

import lombok.Data;

public @Data class Mountain {
    private final String name;
    private final double latitude, longitude;
    private String country;
}
