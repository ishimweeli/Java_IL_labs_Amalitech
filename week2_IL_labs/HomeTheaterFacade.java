package personalExercises;

    public  class HomeTheaterFacade {
        private Amplifier amplifier;
        private DVDPlayer dvdPlayer;
        private Projector projector;
        private Screen screen;

        public HomeTheaterFacade() {
            this.amplifier = new Amplifier();
            this.dvdPlayer = new DVDPlayer();
            this.projector = new Projector();
            this.screen = new Screen();
        }

        public void watchMovie(String movie) {
            System.out.println("Get ready to watch a movie...");
            screen.down();
            projector.on();
            projector.setInput(dvdPlayer);
            dvdPlayer.on();
            dvdPlayer.play(movie);
            amplifier.on();
            amplifier.setSurroundSound();
            amplifier.setVolume(5);
        }

        public void endMovie() {
            System.out.println("Shutting down the movie theater...");
            screen.up();
            projector.off();
            dvdPlayer.stop();
            dvdPlayer.off();
            amplifier.off();
        }

        // Inner classes representing subsystems
        private class Amplifier {
            public void on() { System.out.println("Amplifier is on"); }
            public void off() { System.out.println("Amplifier is off"); }
            public void setSurroundSound() { System.out.println("Surround sound is enabled"); }
            public void setVolume(int level) { System.out.println("Volume set to " + level); }
        }

        private  class DVDPlayer {
            public void on() { System.out.println("DVD Player is on"); }
            public void off() { System.out.println("DVD Player is off"); }
            public void play(String movie) { System.out.println("Now playing: " + movie); }
            public void stop() { System.out.println("DVD Player stopped"); }
        }

        private class Projector {
            public void on() { System.out.println("Projector is on"); }
            public void off() { System.out.println("Projector is off"); }
            public void setInput(DVDPlayer dvdPlayer) { System.out.println("Projector is connected to DVD Player"); }
        }

        private  class Screen {
            public void up() { System.out.println("Screen is up"); }
            public void down() { System.out.println("Screen is down"); }
        }

        // Main method to test the facade
        public static void main(String[] args) {
            HomeTheaterFacade homeTheater = new HomeTheaterFacade();
            homeTheater.watchMovie("The Matrix");
            homeTheater.endMovie();
        }
    }


