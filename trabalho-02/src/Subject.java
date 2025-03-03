public interface Subject {
    public void inscrever(Observer observer);
    public void desinscrever(Observer observer);
    public void notificar();
}
