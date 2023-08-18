public class Main {

/*
  * This is the main method. It creates two threads, one for the music player and one for the worker.
  * The music player thread is started first, and then the worker thread is started.
  * This allows the music player and the rest of the program to run independently of each other.
  * The worker thread will run until it is finished.
* */
  public static void main(String[] args) {
    MusicPlayerClass musicPlayer = new MusicPlayerClass();
    WorkerClass worker = new WorkerClass();

    Thread musicThread = new Thread(musicPlayer::start);
    Thread workerThread = new Thread(worker::start);

    workerThread.start();
    musicThread.start();
  }
}
//---------------------------------------END-OF-FILE----------------------------------------------//