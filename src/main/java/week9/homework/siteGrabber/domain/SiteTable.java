package week9.homework.siteGrabber.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin
 * User: Partizanin
 * Date: 29.06.2014
 * Time: 17:21
 * To change this template use File|Setting|File Templates.
 */
@Component
@Entity
@Table(name = "CONTENTS")
public class SiteTable implements Serializable {


    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CONTENTS_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

    @Id
    @Column(name = "CONTENTS_ID")
    private Long id;

    @Column(name = "SITE_ADDRESS")
    private String address;

    @Column(name = "SITE_CONTENT")
    private String content;

    public SiteTable(String address) {
        this.address = address;
    }

    public SiteTable() {

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SiteTable{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
