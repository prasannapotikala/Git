
import org.eclipse.swt.graphics.Color;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public class SWTFirst {
  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    int i = display.getDismissalAlignment();
    int j =display.getDoubleClickTime();
    int k = display.getDepth();
    Monitor monitor=display.getPrimaryMonitor();
    Color c=display.getSystemColor(i);
    Font f =display.getSystemFont();
    System.out.println(i);
    System.out.println(j);
    System.out.println(k);
    System.out.println(monitor);
    System.out.println(c);
    System.out.println(f);




    shell.setText("Hello, world!");
    System.out.println("Display Bounds=" + display.getBounds() + " Display ClientArea="+ display.getClientArea());
   
    shell.open();
    // Set up the event loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        // If no more entries in the event queue
        display.sleep();
      }
    }
    display.beep();

    display.dispose();
  }
}