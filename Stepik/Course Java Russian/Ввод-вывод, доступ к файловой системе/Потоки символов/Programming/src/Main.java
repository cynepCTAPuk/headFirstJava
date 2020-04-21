public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
    Reader reader = new InputStreamReader(inputStream, charset);
    try (StringWriter stringWriter = new StringWriter()) {
        int data;
        while ((data = reader.read()) != -1) {
            stringWriter.write(data);
        }
        return stringWriter.toString();
    }
}