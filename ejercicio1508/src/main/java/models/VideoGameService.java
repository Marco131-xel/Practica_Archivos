package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VideoGameService {
    private List<VideoGame> videoGames;
    private final String filepath;

    public VideoGameService(String filepath) {
        this.videoGames = new ArrayList<>();
        this.filepath = filepath + File.separator + "list.lc";
        loadData();
    }

    private void saveInFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath))){
            objectOutputStream.writeObject(this.videoGames);
        } catch (Exception e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }

    private List<VideoGame> returnVideoGameList(Object object) {
        if (!(object instanceof List<?>)){
            return null;
        }
        final List<?> list = (List<?>) object;
        for (Object item : list){
            if (!(item instanceof VideoGame)){
                return null;
            }
        }
        return (List<VideoGame>) list;
    }

    private void loadData() {
        final File file = new File(filepath);
        if (file.exists()) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                final Object object = objectInputStream.readObject();
                final List<VideoGame> list = returnVideoGameList(object);
                if (list != null) {
                    System.out.println("No es una lista de videojuegos");
                    return;
                }
                this.videoGames = list;
                System.out.println("Se cargaron los datos");
            } catch (Exception e) {
                System.out.println("Hubo un erro al cargar el archivo \n");
            }
        } else {
            System.out.println("El archivo no existe");
        }
    }
}
