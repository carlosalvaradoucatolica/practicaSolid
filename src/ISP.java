//Disponemos de la siguiente clase Contacto:

public class Contacto {
String name, address, emailAddress, telephone;
public void setName(String n) { name=n; }
public String getName() { return name; }
public void setAddress(String a) { address=a; }
public String getAddress() { return address; }
public void setEmailAddress(String ea) { emailAddress=ea; }
public String getEmailAddress() { return emailAddress; }
public void setTelephone(String t) { telephone=t; }
public String getTelephone() { return telephone; }
}
// y dos clases adicionales que envían correos electrónicos y SMS’s tal y como se muestra a
// continuación:
public class EmailSender {
public static void sendEmail(Contacto c, String message){
//Envía un mensaje la direccion de correo del Contacto c.
}
}
public class SMSSender {
public static void sendSMS(Contacto c, String message){
//Envía un mensaje SMS al teléfono del Contacto c.
}
}

// Consultas:
// 1. ¿Qué información necesitan las clases EmailSender y SMSSender de la clase Contacto
// para realizar su tarea, y qué información recogen? Consideras que incumplen en
// principio ISP.
// 2. Refactoriza las clases anteriores, sustituyendo el parámetro Contacto, por una interfaz.
// Esta interfaz tendrá los métodos necesarios para acceder a la información que necesita
// en método. Modifica también la clase Contacto.
// 3. Piensa que después de refactorización, la clase GmailAccount (con alguna modificación)
// podrá ser enviada a la clase EmailSender pero no a la clase SMSSender.
public class GmailAccount {
String name, emailAddress;
}
// Crea un programa que permita invocar al método sendEmail de la clase EmailSender con
// un objeto de la clase GmailAccount.

// Respuestas:
// 1. La clase EmailSender necesita el emailAddress del Contacto para poder
// enviar el mensaje a la dirección correspondiente y la clase SMSSender necesita el
// telephone Contacto para enviar el mensaje SMS al número correspondiente. Las dos clases recogen el mensaje que se desea enviar como parámetro.
// incumplen con el principio ISP, ya que ambas dependen de la clase Contacto, que contiene
// información que no es necesaria para su funcionamiento. Por ejemplo, si se desea enviar 
// un mensaje únicamente por correo electrónico, no es necesario proporcionar la dirección física 
// o el número de teléfono del contacto. Sería preferible tener una interfaz separada para cada tipo
// de contacto y que cada clase dependa solo de la interfaz que necesita para realizar su tarea.

//2. - 3.

//Se crea una interfaz llamada "ContactInfo" que incluye los métodos necesarios para acceder a la información que necesita cada clase.

public interface ContactInfo {
    String getName();
    String getAddress();
    String getEmailAddress();
    String getTelephone();
}

//Se modifica la clase "Contacto" para implementar la interfaz "ContactInfo".

public class Contacto implements ContactInfo {
    private String name;
    private String address;
    private String emailAddress;
    private String telephone;
    
    public void setName(String n) { name=n; }
    public String getName() { return name; }
    public void setAddress(String a) { address=a; }
    public String getAddress() { return address; }
    public void setEmailAddress(String ea) { emailAddress=ea; }
    public String getEmailAddress() { return emailAddress; }
    public void setTelephone(String t) { telephone=t; }
    public String getTelephone() { return telephone; }
}

// Se modifican las clases "EmailSender" y "SMSSender" para recibir como parámetro un objeto de 
// la interfaz "ContactInfo", de esta manera para obtener solo la información necesaria.

public class EmailSender {
    public static void sendEmail(ContactInfo c, String message){
        //Envía un mensaje a la direccion de correo del objeto ContactInfo.
    }
}

public class SMSSender {
    public static void sendSMS(ContactInfo c, String message){
        //Envía un mensaje SMS al teléfono del objeto ContactInfo.
    }
}

// Se modifica la clase "GmailAccount" para implementar la interfaz "ContactInfo".

public class GmailAccount implements ContactInfo {
    private String name;
    private String emailAddress;
    
    public String getName() { return name; }
    public String getAddress() { return null; }
    public String getEmailAddress() { return emailAddress; }
    public String getTelephone() { return null; }
}

// Se crea un programa que permita llamar al método "sendEmail" de la clase "EmailSender" con un objeto de la clase "GmailAccount".

public class Programa {
    public static void main(String[] args) {
        GmailAccount account = new GmailAccount();
        account.setName("Daniel Angel");
        account.setEmailAddress("daangel66@ucatolica.edu.co");
        
        EmailSender.sendEmail(account, "Hola mundo att: Daniel");
    }
}

//Explicacion: Se separa la funcionalidad de cada clase en interfaces más específicas, evitando la dependencia de métodos que no se utilizan.
//Además, hemos permitido que la clase "GmailAccount" pueda ser utilizada por la clase "EmailSender", pero no por la clase "SMSSender" cumpliendo con el Principio ISP.