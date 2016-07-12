package exampleplugin.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;

import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"ExamplePlugin",
				"Hello, Eclipse world");
//      When scanning the classes of the project itself, the scanner can get the classes of a given package.
//		FastClasspathScanner scanner = new FastClasspathScanner("mypack.core").verbose();
//		List<String> classNames = scanner.scan().getNamesOfAllClasses();
//		for (String name : classNames) {
//			System.out.println("The class: " + name);
//		}
		
		// When scanning the classes of the jars of plug-in dependencies, the scanner cannot get the classes of a given package.
		FastClasspathScanner scanner = new FastClasspathScanner("org.eclipse.swt.accessibility").verbose();
		List<String> classNames = scanner.scan().getNamesOfAllClasses();
		for (String name : classNames) {
			System.out.println("The class: " + name);
		}
		return null;
	}
}
