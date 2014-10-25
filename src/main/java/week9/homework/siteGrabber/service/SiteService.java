package week9.homework.siteGrabber.service;

import week9.homework.siteGrabber.domain.SiteTable;

import java.io.IOException;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 29.06.2014
 * Time: 17:29
 * To change this template use File|Setting|File Templates.
 */
public interface SiteService {

    void createContent(SiteTable site);

    String searchLinks(String siteContent);

    void writeContentToFile(String siteContent);
}
