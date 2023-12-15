package com.sample;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class GameDesignServicesChoose {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public static final String viewQuestion(JFrame frame, String question, String[] options) {
        int n = JOptionPane.showOptionDialog(frame,
                                            question,
                                            "Game Design Services Choose",
                                            JOptionPane.YES_NO_OPTION,
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            options,
                                            options[0]);
                                            
      System.out.print( question + " - " );
      if( n >=0 ) {
	      System.out.println(options[n]);
	      return options[n];
      }
      
      System.exit(0);
      return "";
}
    
    public static final boolean showResult(JFrame frame, String result) {
    	JOptionPane.showMessageDialog(frame,
    		    "Your career should be: " + result,
    		    "RESULT",
    		    JOptionPane.PLAIN_MESSAGE);
    	
    	System.out.println( "--------------------------------\nRESULT: " + result );
    	return true;
    }
}
