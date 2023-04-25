package org.alda.dsm.utl.examenmongonube;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ConexionMongoNube{
    ConnectionString connectionString = new ConnectionString("mongodb+srv://Alda:2418Fran11@cluster0.o8h9oq7.mongodb.net/" +
            "?retryWrites=true&w=majority");
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("examenBDMongo");

    public boolean insertar(Alumno alumno){
        MongoCollection<Document> collection=database.getCollection("Alumno");
        Document document=new Document("idAlumno", alumno.getIdAlumno())
                .append("matricula", alumno.getMatricula())
                .append("nombre", alumno.getNombre())
                .append("primerApellido", alumno.getPrimerApellido())
                .append("segundoApellido", alumno.getSegundoApellido())
                .append("carrera", alumno.getCarrera());
        collection.insertOne(document);
        return true;
    }

    public boolean actualizar(Alumno alumnoAnterior, Alumno alumnoNuevo){
        MongoCollection<Document> collection = database.getCollection("Alumno");
        Bson filter = Filters.eq("idAlumno", alumnoAnterior.getIdAlumno());
        Document document = new Document("idAlumno", alumnoNuevo.getIdAlumno())
                .append("matricula", alumnoNuevo.getMatricula())
                .append("nombre", alumnoNuevo.getNombre())
                .append("primerApellido", alumnoNuevo.getPrimerApellido())
                .append("segundoApellido", alumnoNuevo.getSegundoApellido())
                .append("carrera", alumnoNuevo.getCarrera());
        Bson update = new Document("$set", document);
        UpdateResult result = collection.updateOne(filter, update);
        System.out.println(result.getModifiedCount() + " documentos modificados");
        return true;
    }

    public boolean mostrar() {
        try {
            MongoCollection<Document> collection = database.getCollection("Alumno");
            FindIterable<Document> documents = collection.find();
            for (Document document : documents) {
                System.out.println(document.toJson());
            }
            return true;
        } catch (Exception e){
            System.out.println("Hubo un error");
            return false;
        }
    }

    public boolean eliminar(int idAlumno){
        MongoCollection<Document> collection = database.getCollection("Alumno");
        Bson filter = Filters.eq("idAlumno", idAlumno);
        DeleteResult result = collection.deleteOne(filter);
        System.out.println(result.getDeletedCount() + " documentos eliminados");
        return true;
    }
}
