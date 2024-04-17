import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;



public class FileDownloader {
    public static void main(String[] args) {
        String[] urls={
                "https://example.com/file1.txt",
                "https://example.com/file1.txt",
        };
        for(String url:urls){
            DownloadThread  thread=new DownloadThread(url);
            thread.start();
        }

    }

    public static class DownloadThread extends  Thread{
        public DownloadThread(String url) {
        }

        public void downloadFile(String urlString) throws IOException{
            URL url=new URL(urlString);
            try(
                    InputStream in=url.openStream();
            ){
                FileOutputStream out=new FileOutputStream(getFileName(urlString));
            }
        }

        private String getFileName(String urlString) {
            return urlString.substring(urlString.lastIndexOf('/')+1);

        }
    }

}