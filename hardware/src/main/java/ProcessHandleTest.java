import java.util.Optional;

public class ProcessHandleTest {
    public static void main(String[] args) {
        System.out.println(String.format("%-6s %-6s %-18s %-26s %-11s %-20s",
                "  pid", "   pid", "   user", "   startInstant", "commandLine", "   totalCPU"));
        ProcessHandle.allProcesses().forEach(process -> System.out.println(processDetails(process)));
    }

    private static String processDetails(ProcessHandle process) {
        return String.format("%6d %6s %18s %26s %-11s %20s",
                process.pid(),
                text(process.parent().map(ProcessHandle::pid)),
                text(process.info().user()),
                text(process.info().startInstant()),
                text(process.info().commandLine()),
                text(process.info().totalCpuDuration())
        );
    }

    private static String text(Optional<?> optional) {
        return optional.map(Object::toString).orElse("-");
    }
}
