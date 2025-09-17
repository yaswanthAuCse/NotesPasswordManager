  import java.util.*;

    public class Main {
        private static List<String> notes = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);
        private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
        private static final String DIGITS = "0123456789";
        private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;:',.<>?";

        public static void main(String[] args) {
            int choice;
            do {
                System.out.println("\n===== Notes and Password Builder =====");
                System.out.println("1. Add Note");
                System.out.println("2. View Notes");
                System.out.println("3. Delete Note");
                System.out.println("4. Generate Password");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addNote();
                        break;
                    case 2:
                        viewNotes();
                        break;
                    case 3:
                        deleteNote();
                        break;
                    case 4:
                        generatePassword();
                        break;
                    case 5:
                        System.out.println("Thank you for using the app!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 5);
        }

        // Add a new note
        private static void addNote() {
            System.out.print("Enter your note: ");
            String note = scanner.nextLine();
            notes.add(note);
            System.out.println("Note added successfully.");
        }

        // View all notes
        private static void viewNotes() {
            if (notes.isEmpty()) {
                System.out.println("No notes available.");
            } else {
                System.out.println("Your Notes:");
                for (int i = 0; i < notes.size(); i++) {
                    System.out.println((i + 1) + ". " + notes.get(i));
                }
            }
        }

        // Delete a note
        private static void deleteNote() {
            viewNotes();
            if (!notes.isEmpty()) {
                System.out.print("Enter note number to delete: ");
                int index = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (index > 0 && index <= notes.size()) {
                    notes.remove(index - 1);
                    System.out.println("Note deleted successfully.");
                } else {
                    System.out.println("Invalid note number.");
                }
            }
        }

        // Password generator
        private static void generatePassword() {
            System.out.print("Enter password length: ");
            int length = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Include symbols (yes/no)? ");
            String includeSymbols = scanner.nextLine();

            String charSet = UPPER + LOWER + DIGITS;
            if (includeSymbols.equalsIgnoreCase("yes")) {
                charSet += SYMBOLS;
            }

            StringBuilder password = new StringBuilder();
            Random rand = new Random();
            for (int i = 0; i < length; i++) {
                password.append(charSet.charAt(rand.nextInt(charSet.length())));
            }

            System.out.println("Generated Password: " + password);
        }
    }

