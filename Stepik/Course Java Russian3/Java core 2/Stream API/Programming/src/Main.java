Stream<String> uniqueNameStream(Stream<Organization> organizationStream) {
    //enter your code
    return null;
}

interface Organization {
    List<Worker> getWorkers();
}

interface Worker {
    String getName();
}