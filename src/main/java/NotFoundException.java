public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Элемент с идентификатором " + id + " не найден");
    }
}
