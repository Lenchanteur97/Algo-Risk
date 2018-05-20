import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class MasqueAcronyme extends MaskFormatter {
	private static final long serialVersionUID = 1L;
	
	public MasqueAcronyme() {
		try {
			this.setMask("UUU");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
