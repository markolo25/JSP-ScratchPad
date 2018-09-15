/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author markl
 */
@ManagedBean
@RequestScoped
public class scratchBean implements Serializable {

    /**
     * Creates a new instance of scratchBean
     */
    public scratchBean() {
    }

    /*checkBox*/
    public boolean checkBox;

    public boolean isCheckBox() {
        return this.checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    public String checkBoxState() {
        String result = Boolean.toString(this.checkBox);
        return result;
    }
    /*checkBox End*/

 /*File Upload
    https://jsflive.wordpress.com/2013/04/23/jsf22-file-upload/
     */
    private Part file;
    private String fileContent;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String save() throws IOException {
        try {
            fileContent = new Scanner(file.getInputStream())
                    .useDelimiter("\\A").next();
        } catch (IOException e) {
            // Error handling
        }
        return "result";
    }

    /*disabled/hidden Date Field*/
    private Date subDate;
    private Date modDate;
    private boolean hiddenField;

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        if (subDate != null) {
            this.subDate = subDate;
        }
        else{
            this.subDate = new Date();
        }
    }

    public boolean isHiddenField() {
        return hiddenField;
    }

    public void setHiddenField(boolean hiddenField) {
        this.hiddenField = hiddenField;
    }

    public String getSubStringTime() {
        return new SimpleDateFormat("hhmmss").format(this.subDate);
    }

    public void setSubStringTime(String time) {
        try {
            this.modDate = new SimpleDateFormat("mmddyyhhmmss").parse(new SimpleDateFormat("mmddyy").format(this.subDate) + time);
        } catch (ParseException ex) {
            Logger.getLogger(scratchBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getTestSetSubStringTIme() {
        this.setSubStringTime("112233");
        return this.modDate.toString();
    }

}
