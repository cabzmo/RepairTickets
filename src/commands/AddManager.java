package commands;

import main.CentralException;
import model.Central;
import model.Manager;
import model.Person;

public class AddManager implements Command {

    private String name;
    private String phone;
    private String email;

    public AddManager(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public void execute(Central central) throws CentralException {
        int maxID = 0;
        if (central.getPeople().size() > 0) {
            int lastIndex = central.getPeople().size() - 1;
            maxID = central.getPeople().get(lastIndex).getID();
        }

        for (Person person : central.getPeople()) {
            if (person.getPhone().equals(this.phone)) {
                throw new CentralException(
                        "A user with with the phone number " + this.phone + " is already registered");
            } else if (person.getEmail().equals(this.email)) {
                throw new CentralException("A user with with the email " + this.email + " is already registered");
            }
        }

        Manager manager = new Manager(++maxID, name, phone, email);
        central.addManager(manager);

    }

}
