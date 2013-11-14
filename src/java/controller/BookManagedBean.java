/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static com.google.common.io.ByteStreams.toByteArray;
import entities.BookEntity;
import facade.BookEntityFacade;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author hamilton.matos
 */
@ManagedBean
@RequestScoped
public class BookManagedBean {

    @EJB
    BookEntityFacade service;

    private BookEntity newBook;
    private Part bookFile;
    private List<BookEntity> livros;

    /**
     * Creates a new instance of PhoneManagedBean
     */
    public BookManagedBean() {
    }

    public String save() throws IOException {
        getNewBook().setBookFile(toByteArray(bookFile.getInputStream()));
        service.create(newBook);
        addSucessMessage("livro criado com sucesso!");
        return "listaLinks?faces-redirect=true";
    }

    public Part getBookFile() {
        return bookFile;
    }

    public void setBookFile(Part bookFile) {
        this.bookFile = bookFile;
    }

    public BookEntity getNewBook() {
        if (newBook == null) {
            newBook = new BookEntity();
        }
        return newBook;
    }

    public void setNewBook(BookEntity newBook) {
        this.newBook = newBook;
    }

    public void download(BookEntity livro) throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.responseReset();
        OutputStream responseOutputStream = ec.getResponseOutputStream();

        byte[] source = service.find(livro.getId()).getBookFile();

        InputStream inputStream = new ByteArrayInputStream(source);
        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = inputStream.read(bytesBuffer)) > 0) {
            responseOutputStream.write(bytesBuffer, 0, bytesRead);
        }
        responseOutputStream.flush();
        inputStream.close();
        responseOutputStream.close();
        fc.responseComplete();
    }

    private void addSucessMessage(String sucesso) {
        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, sucesso, sucesso);
        FacesContext.getCurrentInstance().addMessage(null, m);
    }

    public void setLivros(List<BookEntity> livros) {
        this.livros = livros;
    }

    public List<BookEntity> getLivros() {
        livros = service.findAll();
        return livros;
    }

}
