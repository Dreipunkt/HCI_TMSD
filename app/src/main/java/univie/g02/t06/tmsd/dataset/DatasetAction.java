package univie.g02.t06.tmsd.dataset;

import java.io.File;
import java.util.ArrayList;

import ncsa.hdf.object.h5.H5File;

public class DatasetAction {

    private static final String PATH = ""; // Pfad zu .h5 Daten
    private ArrayList<File> allFiles;

    public DatasetAction() {
        if (allFiles == null) {
            allFiles = new ArrayList<>();
            listf(PATH, allFiles);
        }
    }

    /**
     * Liefert alle Songs, die title enthalten.
     *
     * @param title
     * @return
     */

    public ArrayList<Song> getSongsByTitle(String title) throws Exception {
        ArrayList<Song> songs = new ArrayList<>();

        for (File f : allFiles) {
            H5File hdf = hdf5_getters.hdf5_open_readonly(f.getAbsolutePath());
            String fileTitle = hdf5_getters.get_title(hdf);

            if (fileTitle.contains(title)) {
                songs.add(new Song(fileTitle, hdf5_getters.get_artist_name(hdf), hdf5_getters.get_duration(hdf), hdf5_getters.get_year(hdf)));
            }

            hdf5_getters.hdf5_close(hdf);
        }

        return songs;
    }

    /**
     * Liefert alle Songs, die artist enthalten.
     *
     * @param artist
     * @return
     */

    public ArrayList<Song> getSongsByArtist(String artist) throws Exception {
        ArrayList<Song> songs = new ArrayList<>();

        for (File f : allFiles) {
            H5File hdf = hdf5_getters.hdf5_open_readonly(f.getAbsolutePath());
            String fileArtist = hdf5_getters.get_artist_name(hdf);

            if (fileArtist.contains(artist)) {
                songs.add(new Song(hdf5_getters.get_title(hdf), fileArtist, hdf5_getters.get_duration(hdf), hdf5_getters.get_year(hdf)));
            }

            hdf5_getters.hdf5_close(hdf);
        }

        return songs;
    }

    /**
     * Liefert alle Songs, des Jahres year.
     *
     * @param year
     * @return
     */

    public ArrayList<Song> getSongsByYear(int year) throws Exception {
        ArrayList<Song> songs = new ArrayList<>();

        for (File f : allFiles) {
            H5File hdf = hdf5_getters.hdf5_open_readonly(f.getAbsolutePath());
            int fileYear = hdf5_getters.get_year(hdf);

            if (fileYear == year) {
                songs.add(new Song(hdf5_getters.get_title(hdf), hdf5_getters.get_artist_name(hdf), hdf5_getters.get_duration(hdf), fileYear));
            }

            hdf5_getters.hdf5_close(hdf);
        }

        return songs;
    }

    /**
     * Recursive Suche nach Daten.
     *
     * @param directoryName
     * @param files
     */

    private void listf(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }
}
