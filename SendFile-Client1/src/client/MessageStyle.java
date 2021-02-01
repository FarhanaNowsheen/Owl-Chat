
package client;

import java.awt.*;
import javax.swing.text.*;



public class MessageStyle {
    
    
    /*
        Message Content Style
    */
    public static AttributeSet styleMessageContent(Color color, String fontFamily, int size){
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, fontFamily); //  FontFamily
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        aset = sc.addAttribute(aset, StyleConstants.FontSize, size);
        return aset;
    }
}
