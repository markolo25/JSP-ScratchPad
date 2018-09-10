/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Scanner;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.Part;

/**
 *
 * @author markl
 */
@ManagedBean
@RequestScoped
public class scratchBean {

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

}
