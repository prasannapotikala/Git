
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class ShellWindowCloseEvent {

  public static void main(String[] args) {
    Display display = new Display();
    final Shell shell = new Shell(display,SWT.TIME| SWT.H_SCROLL | SWT.V_SCROLL);
    shell.addListener(SWT.Close, new Listener() {
      public void handleEvent(Event event) {
        System.out.println("close");
      }
    });
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }
}