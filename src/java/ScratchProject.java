
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mark
 */


@Named
@RequestScoped
public class ScratchProject implements Serializable {

    public ScratchProject() {
    }

    
  
    
    private boolean checkBox = false;

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
    
    public String checkState(){
        System.out.println(this.isCheckBox());
        return "Success";
    }
    
    
    
    
    
}
