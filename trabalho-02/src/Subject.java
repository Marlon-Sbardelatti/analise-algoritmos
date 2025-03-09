public interface Subject {
    void inscrever(Observer observer);
    void desinscrever(Observer observer);
    void notificar();
}
