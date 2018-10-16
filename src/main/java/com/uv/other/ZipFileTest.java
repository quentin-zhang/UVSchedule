package com.uv.other;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class ZipFileTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void add_all_files_from_a_directory_to_a_zip_archive() throws Exception {
        File source = new File("D:\\pic\\20180915");
//        File destination = new File("D:\\pic\\20180915.zip");
//        destination.delete();
        Boolean isDelete = source.delete();
        System.out.println(isDelete);
//        addFilesToZip(source, destination);


//        assertZipContent(destination);
    }

    /**
     * Add all files from the source directory to the destination zip file
     *
     * @param source      the directory with files to add
     * @param destination the zip file that should contain the files
     * @throws IOException      if the io fails
     * @throws ArchiveException if creating or adding to the archive fails
     */
    private void addFilesToZip(File source, File destination) throws IOException, ArchiveException {
        OutputStream archiveStream = new FileOutputStream(destination);
        ArchiveOutputStream archive = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.ZIP, archiveStream);

        Collection<File> fileList = FileUtils.listFiles(source, null, true);

        for (File file : fileList) {
            String entryName = getEntryName(source, file);
            ZipArchiveEntry entry = new ZipArchiveEntry(entryName);
            archive.putArchiveEntry(entry);

            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));

            IOUtils.copy(input, archive);
            input.close();
            archive.closeArchiveEntry();
        }

        archive.finish();
        archiveStream.close();
    }

    /**
     * Remove the leading part of each entry that contains the source directory name
     *
     * @param source the directory where the file entry is found
     * @param file   the file that is about to be added
     * @return the name of an archive entry
     * @throws IOException if the io fails
     */
    private String getEntryName(File source, File file) throws IOException {
        int index = source.getAbsolutePath().length() + 1;
        String path = file.getCanonicalPath();

        return path.substring(index);
    }

    //解析工人
    public void parseWorker()
    {
        JSONObject json = getMockData();
        formatReconcContent(json);
    }

    //解析器
    public List<String> formatReconcContent(JSONObject json){
        List<String> contentArray = new ArrayList<String>();
        JSONArray array = json.getJSONArray("items");
        for(int i=0;i<array.size();i++){
            List<String> columns = Arrays.asList(array.get(i).toString().split(";"));
            System.out.println(columns.toString());
        }
        return contentArray;
    }

    //mock数据
    public JSONObject getMockData()
    {
        JSONObject json = new JSONObject();
        JSONArray items = new JSONArray();
        items.add("38160987470002327282270;20180904160993110012046000253;2018-09-04 09:45:21;1;6311;;;;;;1;");
        items.add("38160987470002327282270;20180904160993110012046000254;2018-09-04 09:46:21;1;6312;;;;;;2;");
        items.add("38160987470002327282270;20180904160993110012046000255;2018-09-04 09:47:21;1;6313;;;;;;3;");
        json.put("items", items);

        return json;
    }
//    private void assertZipContent(File destination) throws IOException {
//        ZipFile zipFile = new ZipFile(destination);
//
//        ZipArchiveEntry readme = zipFile.getEntry("readme.txt");
//        assertNotNull(readme);
//
//        Enumeration<ZipArchiveEntry> entries = zipFile.getEntries();
//        int numberOfEntries = 0;
//        while (entries.hasMoreElements()) {
//            numberOfEntries++;
//            entries.nextElement();
//        }
//        assertThat(numberOfEntries, is(1));
//    }
}
