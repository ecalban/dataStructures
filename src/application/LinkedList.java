package application;

public class LinkedList {

	static LinkedList ll = new LinkedList();

	Animal front;
	Animal rear;

	LinkedList() {
		front = null;
		rear = null;
	}

	void addLast(Animal animal) {
		if (front == null && rear == null) {
			front = animal;
			rear = animal;
		} else {
			rear.next = animal;
			rear = animal;
		}
	}

	void printTheLL() {
		Animal temp = front;
		while (temp != null) {
			System.out.println(temp.animalId + " " + temp.animalKind + " " + temp.animalName + " " + temp.animalAge);
			temp = temp.next;
		}
		System.out.println("--------------------------------------------------");
	}

	boolean LLQuery(Long searchedId) {
		Animal temp = front;
		while (temp != null) {
			if (temp.animalId.equals(searchedId)) {
				return true;
			} else {
				temp = temp.next;
			}
		}
		return false;
	}

	String findInLLMakeItString(Long searchedId) {
		String info = "";
		Animal temp = front;
		while (temp != null) {
			if (temp.animalId.equals(searchedId)) {
				info = temp.animalName + " " + temp.animalKind + " " + Integer.toString(temp.animalAge) + " "
						+ Long.toString(temp.animalId);
				break;
			}
			temp = temp.next;
		}
		return info;
	}

	String findInLLreturnTheKind(Long searchedId) {
		Animal temp = front;
		while (temp != null) {
			if (temp.animalId.equals(searchedId)) {
				return temp.animalKind;
			}
			temp = temp.next;
		}
		return "";
	}

	void sortTheLL() {
		if (front == null && rear == null) {
			return;
		}
		Animal temp = front;
		Animal temp2 = temp.next;
		while (temp != rear) {
			while (temp2 != null) {
				if (temp2.animalName.compareTo(temp.animalName) < 0) {
					Long tempId = temp.animalId;
					temp.animalId = temp2.animalId;
					temp2.animalId = tempId;

					String tempKind = temp.animalKind;
					temp.animalKind = temp2.animalKind;
					temp2.animalKind = tempKind;

					String tempName = temp.animalName;
					temp.animalName = temp2.animalName;
					temp2.animalName = tempName;
				}
				temp2 = temp2.next;
			}
			temp = temp.next;
			if (temp != null) {
				temp2 = temp.next;
			}
		}
	}

	void removeLast() {
		Animal seconToLast = null;
		Animal temp = front;
		while (temp != null && temp.next != null) {
			seconToLast = temp;
			temp = temp.next;
		}
		if (temp == front) {
			front = null;
			rear = null;
		} else if (seconToLast != null) {
			seconToLast.next = null;
			rear = seconToLast;
		}
	}

	void removeFirst() {
		if (front != null) {
			front = front.next;
			if (front == null) {
				rear = null;
			}
		}
	}

	void removeFromLL(Long id) {
		if (front == rear) {
			resetTheLL();
			return;
		}
		if (front != null && front.animalId.equals(id)) {
			removeFirst();
			return;
		}
		if (rear != null && rear.animalId.equals(id)) {
			removeLast();
			return;
		}
		Animal temp = front;
		while (temp != null && temp.next != null) {
			if (temp.next.animalId.equals(id)) {
				temp.next = temp.next.next;
				if (temp.next == null) {
					rear = temp;
				}
				return;
			}
			temp = temp.next;
		}
	}

	void resetTheLL() {
		front = null;
		rear = null;
	}
}
