package application;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

	private Stage stage;
	private Scene scene;

	// SWITCH OPERATIONS ON WINDOWS

	@FXML
	public void switchToSceneAdminLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneUserLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneAdmin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneUser(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneAdminDisplayTheAnimals(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminDisplayTheAnimals.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneUserDisplayTheAnimals(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("UserDisplayTheAnimals.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneMain(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneAdminShowTheAnimals(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminShowTheAnimals.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneAdminAnimalRemove(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminAnimalRemove.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneAdminAnimalAdd(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminAnimalAdd.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneAdminAnimalUpdate(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminAnimalUpdate.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void switchToSceneAdminAnimalSearch(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminAnimalSearch.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	// ADMIN LOGIN OPERATIONS

	@FXML
	private TextField adminLoginUserNameTextField;
	@FXML
	private PasswordField adminLoginPasswordPasswordField;

	@FXML
	private Label adminLoginUserNameLabel;
	@FXML
	private Label adminLoginPasswordLabel;

	private static String adminName = "ecalban";
	private static String adminPassword = "eren12345";
	private static String enteredAdminName;
	private static String enteredAdminPassword;

	@FXML
	public void adminLoggingInLogin(ActionEvent event) throws IOException {

		Tooltip usernameTooltip = new Tooltip("Username Information:\n"
				+ "-Uppercase and lowercase letters (A-Z, a-z) and digits (0-9) must be used.\n"
				+ "-The username must be between 3 and 15 characters long.\n");
		Tooltip passwordTooltip = new Tooltip("Password Information:\n"
				+ "-Uppercase and lowercase letters (A-Z, a-z) and digits (0-9) must be used.\n"
				+ "-The password must be between 8 and 20 characters long.\n");

		adminLoginUserNameLabel.setTooltip(usernameTooltip);
		adminLoginPasswordLabel.setTooltip(passwordTooltip);

		// username control
		try {
			enteredAdminName = adminLoginUserNameTextField.getText().toString();
			boolean adminNameControl = true;

			// length control
			if (enteredAdminName.length() < 3 || enteredAdminName.length() > 15) {
				adminNameControl = false;
			}

			// character control
			for (int i = 0; i < enteredAdminName.length(); i++) {
				char character = enteredAdminName.charAt(i);
				if (!Character.isLetterOrDigit(character)) {
					adminNameControl = false;
					break;
				}
			}
			if (!adminNameControl) {
				adminLoginUserNameLabel.setText("Username: " + "\n(Invalid username)");
				return;
			}
			if (!enteredAdminName.equals(adminName)) {
				adminLoginUserNameLabel.setText("Username: " + "\n(User not found)");
				return;
			} else {
				adminLoginUserNameLabel.setText("Username: ");
			}
		} catch (Exception e) {
			adminLoginUserNameLabel.setText("Username: " + "\n(Enter a valid username)");
			return;
		}

		// password control
		try {
			enteredAdminPassword = adminLoginPasswordPasswordField.getText().toString();
			boolean adminPasswordControl = true;

			// length control
			if (enteredAdminPassword.length() < 8 || enteredAdminPassword.length() > 20) {
				adminPasswordControl = false;
			}

			// character control
			for (int i = 0; i < enteredAdminPassword.length(); i++) {
				char character = enteredAdminPassword.charAt(i);
				if (!Character.isLetterOrDigit(character)) {
					adminPasswordControl = false;
					break;
				}
			}

			if (!adminPasswordControl) {
				adminLoginPasswordLabel.setText("Password: " + "\n(Invalid password)");
				return;
			}

			if (!enteredAdminPassword.equals(adminPassword)) {
				adminLoginPasswordLabel.setText("Password: " + "\n(Incorrect password. Please try again)");
				return;
			} else {
				adminLoginPasswordLabel.setText("Password: ");
			}
		} catch (Exception e) {
			adminLoginPasswordLabel.setText("Password: " + "\n(Enter a valid password)");
			return;
		}
		switchToSceneAdmin(event);

	}

	// USER LOGIN OPERATIONS

	@FXML
	private TextField userLoginUserNameTextField;
	@FXML
	private PasswordField userLoginPasswordPasswordField;

	@FXML
	private Label userLoginUserNameLabel;
	@FXML
	private Label userLoginPasswordLabel;

	private static String userName = "ECALBAN";
	private static String userPassword = "EREN12345";
	private static String enteredUserName;
	private static String enteredUserPassword;

	@FXML
	public void userLoggingInLogin(ActionEvent event) throws IOException {

		Tooltip usernameTooltip = new Tooltip("Username Information:\n"
				+ "-Uppercase and lowercase letters (A-Z, a-z) and digits (0-9) must be used.\n"
				+ "-The username must be between 3 and 15 characters long.\n");
		Tooltip passwordTooltip = new Tooltip("Password Information:\n"
				+ "-Uppercase and lowercase letters (A-Z, a-z) and digits (0-9) must be used.\n"
				+ "-The password must be between 8 and 20 characters long.\n");

		userLoginUserNameLabel.setTooltip(usernameTooltip);
		userLoginPasswordLabel.setTooltip(passwordTooltip);

		// username control
		try {
			enteredUserName = userLoginUserNameTextField.getText().toString();
			boolean userNameControl = true;

			// length control
			if (enteredUserName.length() < 3 || enteredUserName.length() > 15) {
				userNameControl = false;
			}

			// character control
			for (int i = 0; i < enteredUserName.length(); i++) {
				char character = enteredUserName.charAt(i);
				if (!Character.isLetterOrDigit(character)) {
					userNameControl = false;
					break;
				}
			}

			if (!userNameControl) {
				userLoginUserNameLabel.setText("Username: " + "\n(Invalid username)");
				return;
			}

			if (!enteredUserName.equals(userName)) {
				userLoginUserNameLabel.setText("Username: " + "\n(User not found)");
				return;
			} else {
				userLoginUserNameLabel.setText("Username: ");
			}
		} catch (Exception e) {
			userLoginUserNameLabel.setText("Username: " + "\n(Enter a valid username)");
			return;
		}

		// password control
		try {
			enteredUserPassword = userLoginPasswordPasswordField.getText().toString();
			boolean userPasswordControl = true;

			// length control
			if (enteredUserPassword.length() < 8 || enteredUserPassword.length() > 20) {
				userPasswordControl = false;
			}

			// character control
			for (int i = 0; i < enteredUserPassword.length(); i++) {
				char character = enteredUserPassword.charAt(i);
				if (!Character.isLetterOrDigit(character)) {
					userPasswordControl = false;
					break;
				}
			}

			if (!userPasswordControl) {
				userLoginPasswordLabel.setText("Password: " + "\n(Invalid password)");
				return;
			}

			if (!enteredUserPassword.equals(userPassword)) {
				userLoginPasswordLabel.setText("Password: " + "\n(Incorrect password. Please try again)");
				return;
			} else {
				userLoginPasswordLabel.setText("Password: ");
			}
		} catch (Exception e) {
			userLoginPasswordLabel.setText("Password: " + "\n(Enter a valid password)");
			return;
		}
		switchToSceneUser(event);

	}

	// ADMIN ANIMAL ADDING OPERATIONS

	@FXML
	private TextField addAnimalIdTextField;
	@FXML
	private TextField addAnimalKindTextField;
	@FXML
	private TextField addAnimalNameTextField;
	@FXML
	private TextField addAnimalAgeTextField;

	@FXML
	private Label addAnimalIdLabel;
	@FXML
	private Label addAnimalKindLabel;
	@FXML
	private Label addAnimalNameLabel;
	@FXML
	private Label addAnimalAgeLabel;

	private Long animalAddId;
	private String animalAddKind;
	private String animalAddName;
	private int animalAddAge;
	static ArrayList<Long> idListFromText = new ArrayList<Long>();

	public void AdminAnimalAddingAdd(ActionEvent event) throws IOException {
		idListFromText.clear();
		FileManager.createIdListIFromText(FileManager.animal, idListFromText);

		// ID control
		try {
			animalAddId = Long.parseLong(addAnimalIdTextField.getText());
			if (animalAddId >= 999 || animalAddId <= 1) {
				addAnimalIdLabel.setText("Animal ID: " + "\n(Enter an ID between 1 and 999)");
				return;
			}
			if (idListFromText.contains(animalAddId)) {
				addAnimalIdLabel.setText("Animal ID: " + "\n(ID is in use. A new ID has been assigned)");
				Long newId = animalAddId;
				Random random = new Random();
				do {
					int randomNumber = random.nextInt(997) + 2;
					newId = (long) randomNumber;
				} while (idListFromText.contains(newId));
				animalAddId = newId;
				addAnimalIdTextField.setText(animalAddId.toString());
				return;
			}
			if (!idListFromText.contains(animalAddId)) {
				addAnimalIdLabel.setText("Animal ID: ");
			}
		} catch (NumberFormatException e) {
			addAnimalIdLabel.setText("Animal ID: " + "\n(Enter a valid ID)");
			return;
		}

		// Kind control
		animalAddKind = addAnimalKindTextField.getText();
		if (animalAddKind.isEmpty()) {
			addAnimalKindLabel.setText("Animal kind: " + "\n(Kind cannot be empty)");
			return;
		} else if (animalAddKind.length() > 15) {
			addAnimalKindLabel.setText("Animal kind: " + "\n(Must be a maximum of 15 characters)");
			return;
		}
		List<Integer> turkishCharacterCodes = new ArrayList<>();
		turkishCharacterCodes.add((int) 'Ç');
		turkishCharacterCodes.add((int) 'Ğ');
		turkishCharacterCodes.add((int) 'İ');
		turkishCharacterCodes.add((int) 'Ö');
		turkishCharacterCodes.add((int) 'Ş');
		turkishCharacterCodes.add((int) 'Ü');
		turkishCharacterCodes.add((int) 'ç');
		turkishCharacterCodes.add((int) 'ğ');
		turkishCharacterCodes.add((int) 'ı');
		turkishCharacterCodes.add((int) 'ö');
		turkishCharacterCodes.add((int) 'ş');
		turkishCharacterCodes.add((int) 'ü');

		int isKindValid = 0;
		for (int i = 0; i < animalAddKind.length(); i++) {
			char character = animalAddKind.charAt(i);
			int asciiCode = (int) character;
			if ((asciiCode > 64 && asciiCode < 91) || (asciiCode > 96 && asciiCode < 123)) {
				isKindValid++;
			}
			if (turkishCharacterCodes.contains(asciiCode)) {
				isKindValid++;
			}
		}
		if (isKindValid != animalAddKind.length()) {
			addAnimalKindLabel.setText("Animal kind: " + "\n(Kind name must consist of letters a-z or A-Z)");
			return;
		} else {
			addAnimalKindLabel.setText("Animal kind: ");
		}

		// Name control
		animalAddName = addAnimalNameTextField.getText();
		if (animalAddName.isEmpty()) {
			addAnimalNameLabel.setText("Animal name: " + "\n(Name cannot be empty)");
			return;
		} else if (animalAddName.length() > 20) {
			addAnimalNameLabel.setText("Animal name: " + "\n(Must be a maximum of 20 characters)");
			return;
		}
		int isNameValid = 0;
		for (int i = 0; i < animalAddName.length(); i++) {
			char character = animalAddName.charAt(i);
			int asciiCode = (int) character;
			if ((asciiCode > 64 && asciiCode < 91) || (asciiCode > 96 && asciiCode < 123)) {
				isNameValid++;
			}
			if (turkishCharacterCodes.contains(asciiCode)) {
				isNameValid++;
			}
		}
		if (isNameValid == animalAddName.length()) {
			addAnimalNameLabel.setText("Animal name: ");
		}
		if (isNameValid != animalAddName.length()) {
			addAnimalNameLabel.setText("Animal name: " + "\n(Name must consist of letters a-z or A-Z)");
			return;
		}

		// Age control
		try {
			animalAddAge = Integer.parseInt(addAnimalAgeTextField.getText());
			if (animalAddAge < 0) {
				addAnimalAgeLabel.setText("Animal age: " + "\n(Age cannot be negative)");
				return;
			} else if (animalAddAge > 200) {
				addAnimalAgeLabel.setText("Animal age: " + "\n(Must be a maximum of 200 years old)");
				return;
			}
		} catch (NumberFormatException e) {
			addAnimalAgeLabel.setText("Animal age: " + "\n(Enter a valid age)");
			return;
		}

		// Successful Login
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileManager.animal, true))) {
			writer.write(animalAddName + " " + animalAddKind + " " + animalAddAge + " " + animalAddId);
			writer.newLine();
		} catch (IOException e) {
			System.err.println("An error occurred while writing to the file: " + e.getMessage());
		}
		addAnimalIdLabel.setText("Animal ID: ");
		addAnimalKindLabel.setText("Animal kind: ");
		addAnimalNameLabel.setText("Animal name: ");
		addAnimalAgeLabel.setText("Animal age: ");
		idListFromText.clear();
		FileManager.createIdListIFromText(FileManager.animal, idListFromText);
	}

	public void AdminAnimalAddingSave(ActionEvent event) throws IOException {
		LinkedList.ll.resetTheLL();
		FileManager.textToLL(FileManager.animal);
		FileManager.sortedLLToText();
		addAnimalIdLabel.setText("Animal ID: ");
		addAnimalKindLabel.setText("Animal kind: ");
		addAnimalNameLabel.setText("Animal name: ");
		addAnimalAgeLabel.setText("Animal age: ");
	}

	// ADMIN ANIMAL EXTRACTING OPERATIONS

	@FXML
	private TextField removeAnimalIdTextField;
	@FXML
	private Label removeAnimalIdLabel;

	private Long animalRemoveId;

	public void AdminAnimalRemovingRemove(ActionEvent event) throws IOException {
		idListFromText.clear();
		FileManager.createIdListIFromText(FileManager.animal, idListFromText);
		try {
			animalRemoveId = Long.parseLong(removeAnimalIdTextField.getText());
			boolean containsId = idListFromText.contains(animalRemoveId);
			if (animalRemoveId > 999 || animalRemoveId < 1) {
				removeAnimalIdLabel.setText("Animal ID:\n(Enter an ID between 1 and 999)");
				return;
			}

			if (containsId) {
				removeAnimalIdLabel.setText("Animal ID: ");
			} else {
				removeAnimalIdLabel.setText("Animal ID:\n(The ID you entered is not in use)");
				return;
			}
		} catch (NumberFormatException e) {
			removeAnimalIdLabel.setText("Animal ID:\n(Enter a valid ID)");
			return;
		}

		LinkedList.ll.resetTheLL();
		FileManager.textToLL(FileManager.animal);
		LinkedList.ll.removeFromLL(animalRemoveId);
		idListFromText.clear();
		FileManager.createIdListIFromText(FileManager.animal, idListFromText);
	}

	public void AdminAnimalRemovingSave(ActionEvent event) throws IOException {
		LinkedList.ll.sortTheLL();
		FileManager.sortedLLToText();
	}

	// ADMIN ANIMAL DISPLAY OPERATIONS

	@FXML
	private TextArea displayTextArea;

	@FXML
	private void adminShowTheAnimalsLoadTheText(ActionEvent event) {
		try (BufferedReader reader = new BufferedReader(new FileReader(FileManager.animal))) {
			StringBuilder content = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
			displayTextArea.setText(content.toString());
		} catch (IOException e) {
			e.printStackTrace();
			displayTextArea.setText("An error occurred while uploading the file.");
		}
	}

	// ADMIN ANIMAL QUERY OPERATIONS

	@FXML
	private TextArea displayTheSearchTextArea;
	@FXML
	private TextField searchAnimalIdTextField;
	@FXML
	private Label searchAnimalIdLabel;

	private Long animalSearchId;

	@FXML
	public void AdminAnimalSearch(ActionEvent event) throws IOException {
		idListFromText.clear();
		FileManager.createIdListIFromText(FileManager.animal, idListFromText);
		try {
			animalSearchId = Long.parseLong(searchAnimalIdTextField.getText());
			boolean containsId = idListFromText.contains(animalSearchId);

			if (animalSearchId > 999 || animalSearchId < 1) {
				searchAnimalIdLabel.setText("Animal ID:\n(Enter an ID between 1 and 999)");
				displayTheSearchTextArea.clear();
				return;
			}

			if (containsId) {
				searchAnimalIdLabel.setText("Animal ID: ");
			} else {
				searchAnimalIdLabel.setText("Animal ID:\n(No animal found with the entered ID)");
				displayTheSearchTextArea.clear();
				return;
			}

		} catch (NumberFormatException e) {
			searchAnimalIdLabel.setText("Animal ID:\n(Enter a valid ID)");
			displayTheSearchTextArea.clear();
			return;
		}

		// Successful Login
		LinkedList.ll.resetTheLL();
		FileManager.textToLL(FileManager.animal);
		displayTheSearchTextArea.setText(LinkedList.ll.findInLLMakeItString(animalSearchId));
	}


	// ADMIN ANIMAL UPDATING OPERATIONS

	@FXML
	private TextField updateAnimalIdTextField;
	@FXML
	private Label updateAnimalIdLabel;

	private Long animalUpdateId;

	@FXML
	private TextField animalIdToUpdateTextField;
	@FXML
	private TextField animalKindToUpdateTextField;

	@FXML
	public void adminAnimalUpdateNext(ActionEvent event) throws IOException {
		idListFromText.clear();
		FileManager.createIdListIFromText(FileManager.animal, idListFromText);
		try {
			animalUpdateId = Long.parseLong(updateAnimalIdTextField.getText());
			boolean containsId = idListFromText.contains(animalUpdateId);

			if (animalUpdateId > 999 || animalUpdateId < 1) {
				updateAnimalIdLabel.setText("Animal ID:\n(Enter an ID between 1 and 999)");
				return;
			}

			if (containsId) {
				updateAnimalIdLabel.setText("Animal ID: ");
			} else {
				updateAnimalIdLabel.setText("Animal ID:\n(The ID you entered is not in use)");
				return;
			}

		} catch (NumberFormatException e) {
			updateAnimalIdLabel.setText("Animal ID:\n(Enter a valid ID)");
			return;
		}

		FileManager.textToLL(FileManager.animal);
		LinkedList.ll.sortTheLL();
		switchToSceneAdminAnimalUpdateNext(event, animalUpdateId.toString(),
				LinkedList.ll.findInLLreturnTheKind(animalUpdateId));
	}

	private void switchToSceneAdminAnimalUpdateNext(ActionEvent event, String animalId, String animalKind)
			throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminAnimalUpdateNext.fxml"));
		Parent root = loader.load();

		Controller controller = loader.getController();
		controller.setGuncellenecekHayvanId(animalId);
		controller.setGuncellenecekHayvanTur(animalKind);

		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void setGuncellenecekHayvanId(String id) {
		animalIdToUpdateTextField.setText(id);
	}

	public void setGuncellenecekHayvanTur(String tur) {
		animalKindToUpdateTextField.setText(tur);
	}

	@FXML
	private TextField animalNameToUpdateTextField;
	@FXML
	private TextField animalAgeToUpdateTextField;

	@FXML
	private Label animalKindToUpdateLabel;
	@FXML
	private Label animalNameToUpdateLabel;
	@FXML
	private Label animalAgeToUpdateLabel;

	private Long animalIdForUpdate;
	private String animalKindForUpdate;
	private String animalNameForUpdate;
	private int animalAgeForUpdate;

	@FXML
	private void AdminAnimalUpdatingNextUpdate(ActionEvent event) throws IOException {
		idListFromText.clear();
		FileManager.createIdListIFromText(FileManager.animal, idListFromText);
		animalIdForUpdate = Long.parseLong(animalIdToUpdateTextField.getText());
		animalKindForUpdate = animalKindToUpdateTextField.getText();

		// Name control
		animalNameForUpdate = animalNameToUpdateTextField.getText();
		if (animalNameForUpdate.isEmpty()) {
			animalNameToUpdateLabel.setText("Animal name: " + "\n(Name cannot be empty)");
			return;
		} else if (animalNameForUpdate.length() > 20) {
			animalNameToUpdateLabel.setText("Animal name: " + "\n(Must be a maximum of 15 characters)");
			return;
		}
		List<Integer> turkishCharacterCodes = new ArrayList<>();
		turkishCharacterCodes.add((int) 'Ç');
		turkishCharacterCodes.add((int) 'Ğ');
		turkishCharacterCodes.add((int) 'İ');
		turkishCharacterCodes.add((int) 'Ö');
		turkishCharacterCodes.add((int) 'Ş');
		turkishCharacterCodes.add((int) 'Ü');
		turkishCharacterCodes.add((int) 'ç');
		turkishCharacterCodes.add((int) 'ğ');
		turkishCharacterCodes.add((int) 'ı');
		turkishCharacterCodes.add((int) 'ö');
		turkishCharacterCodes.add((int) 'ş');
		turkishCharacterCodes.add((int) 'ü');
		int isNameValid = 0;
		for (int i = 0; i < animalNameForUpdate.length(); i++) {
			char character = animalNameForUpdate.charAt(i);
			int asciiCode = (int) character;
			if ((asciiCode > 64 && asciiCode < 91) || (asciiCode > 96 && asciiCode < 123)) {
				isNameValid++;
			}
			if (turkishCharacterCodes.contains(asciiCode)) {
				isNameValid++;
			}
		}
		if (isNameValid != animalNameForUpdate.length()) {
			animalNameToUpdateLabel.setText("Animal name: " + "\n(Name must consist of letters a-z or A-Z)");
			return;
		} else {
			animalNameToUpdateLabel.setText("Animal name: ");
		}

		// Age control
		try {
			animalAgeForUpdate = Integer.parseInt(animalAgeToUpdateTextField.getText());
			if (animalAgeForUpdate < 0) {
				animalAgeToUpdateLabel.setText("Animal age: " + "\n(Age cannot be negative)");
				return;
			} else if (animalAgeForUpdate > 200) {
				animalAgeToUpdateLabel.setText("Animal age: " + "\n(Must be a maximum of 200 years old)");
				return;
			}
		} catch (NumberFormatException e) {
			animalAgeToUpdateLabel.setText("Animal age: " + "\n(Enter a valid age)");
			return;
		}
		// Successful Login
		LinkedList.ll.resetTheLL();
		FileManager.textToLL(FileManager.animal);
		LinkedList.ll.removeFromLL(animalIdForUpdate);
		Animal animal = new Animal(animalIdForUpdate, animalKindForUpdate, animalNameForUpdate, animalAgeForUpdate);
		LinkedList.ll.addLast(animal);
		idListFromText.clear();
		FileManager.createIdListIFromText(FileManager.animal, idListFromText);
		animalKindToUpdateLabel.setText("Animal kind: ");
		animalNameToUpdateLabel.setText("Animal name: ");
		animalAgeToUpdateLabel.setText("Animal age: ");
	}

	public void AdminAnimalUpdatingSave(ActionEvent event) throws IOException {
		LinkedList.ll.sortTheLL();
		FileManager.sortedLLToText();
	}

}