
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class ShellBehaviourDefault {
  public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display, SWT.SHELL_TRIM);
    shell.setLayout(new GridLayout());

    shell.addShellListener(new ShellListener() {
//when shell is open
      public void shellActivated(ShellEvent event) {
    	 System.out.println("Activated");
      }
//whwn shell is closed
      public void shellClosed(ShellEvent event) {
        MessageBox messageBox = new MessageBox(shell, SWT.APPLICATION_MODAL | SWT.YES | SWT.NO);
        messageBox.setText("Warning");
        messageBox.setMessage("You have unsaved data. Close the shell anyway?");
        if (messageBox.open() == SWT.YES)
          event.doit = true;
       else
          event.doit = false;
      }
      
      //when shell is deactivated
      public void shellDeactivated(ShellEvent arg0) {
      }

      //when shell is minimised
      public void shellDeiconified(ShellEvent arg0) {
      }

      //when shell is maximised
      public void shellIconified(ShellEvent arg0) {
      }
    });

    shell.open();
    // Set up the event loop.
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        // If no more entries in event queue
        display.sleep();
      }
    }
    display.dispose();
  }

}