JukeBox - MC

1) avviare un'activity
2) passare dei dati
3) aprire un file
4) mostrare un toast
5) leggere e scrivere dei dati
6) visualizzare delle immagini
7) riconoscere gli stati di un'activity
    When you open the app it will go through below states: onCreate() –> onStart() –> onResume()
    When you press the back button and exit the app:  onPaused() — > onStop() –> onDestory()
    When you press the home button: onPaused() –> onStop()
    After pressing the home button, again when you open the app from a recent task list:   onRestart() –> onStart() –> onResume()
    After dismissing the dialog or back button from the dialog: onResume()
    If a phone is ringing and user is using the app: onPause() –> onResume()
    After the call ends: onResume()
    When your phone screen is off: onPaused() –> onStop()
    When your phone screen is turned back on: onRestart() –> onStart() –> onResume()
8) usare la classe Log
9) usare git
