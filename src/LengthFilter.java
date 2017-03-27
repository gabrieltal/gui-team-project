/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Paul
 */
import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;
 
/**
 * a DocumentFilter that restricts length. One instance may be shared by many JTextCopmonents.
 * <p>
 * use: ((AbstractDocument)yourComp.getDocument()).setDocumentFilter(new LengthFilter(8));
 * 
 * @author Brian Cole
 */
public class LengthFilter extends DocumentFilter {
 
    private int max;
 
    public LengthFilter(int maxLength) {
        max = maxLength;
    }
 
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
            String text, AttributeSet attr) throws BadLocationException {
        if (fb.getDocument().getLength() + text.length() <= max)
               fb.insertString(offset, text, attr);
          else Toolkit.getDefaultToolkit().beep();
    }
 
    // no need to override remove(): inherited implementation allows all removals
 
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
            String text, AttributeSet attr) throws BadLocationException {
        if (fb.getDocument().getLength() + text.length() - length <= max)
               fb.replace(offset, length, text, attr);
          else Toolkit.getDefaultToolkit().beep();
    }
}