package Singh_Gursharan_100312495_Lab6_7_Exercise1;

import javax.swing.SwingUtilities;

public class TestClass {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Application("Gursharan Singh");
				
			}
			
		});
	}

}
