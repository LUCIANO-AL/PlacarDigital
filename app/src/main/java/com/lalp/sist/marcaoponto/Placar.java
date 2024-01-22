package com.lalp.sist.marcaoponto;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.lalp.sist.marcaoponto.databinding.ActPlacarBinding;
import com.lalp.sist.marcaoponto.databinding.ContentPlacarBinding;

public class Placar extends AppCompatActivity {

    private ActPlacarBinding binding;
    private ContentPlacarBinding bindingplacar;
    private int placaA = 00;
    private int placaB = 00;
    private int diferencaplaca, diferencaplacamodel, valorTotalPontos, contseteA, contseteB;

    InterstitialAd interstitialvitoria, interstitialvitoria2, interstitialvitoria3;
    InterstitialAd interstitialvitoria4, interstitialvitoria5, interstitialvitoria6;
    InterstitialAd interstitialvitoria7, interstitialvitoria8;

    SharedPreferences sharedpreferences, sharedTutorial;
    public SharedPreferences.Editor editorTutorial;

    public static final String mypreference = "mypref";

    public static final String TotalPontosPref = "totalpontosprefKey";
    public static final String TimeAPref = "timeaprefKey";
    public static final String TimeBPref = "timebprefKey";
    public static final String PlacarTimeAPref = "placartimeaprefKey";
    public static final String PlacarTimeBPref = "placartimebprefKey";

    public static final String placarSetAPref = "placarsetapref";
    public static final String placarSetBPref = "placarsetbpref";

    public int contadorads = 0;
    public int contadorturial = 0;

    protected View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActPlacarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        bindingplacar = ContentPlacarBinding.inflate(getLayoutInflater());
        setContentView(bindingplacar.getRoot());

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0) {
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        //bindingplacar.idAdViewPlacar.loadAd(adRequest);
        bindingplacar.idAdViewPlacar2.loadAd(adRequest);

        ///////Carregar interstitiais

        InterstitialAd.load(this, getString(R.string.interstitial_vitoria), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialvitoria = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Toast.makeText(Placar.this, "Falha na apresentação da propaganda.", Toast.LENGTH_SHORT).show();
                        interstitialvitoria = null;
                    }
                });

        InterstitialAd.load(this, getString(R.string.interstitial_vitoria2), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialvitoria2 = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Toast.makeText(Placar.this, "Falha na apresentação da propaganda.", Toast.LENGTH_SHORT).show();
                        interstitialvitoria2 = null;
                    }
                });

        InterstitialAd.load(this, getString(R.string.interstitial_vitoria3), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialvitoria3 = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Toast.makeText(Placar.this, "Falha na apresentação da propaganda.", Toast.LENGTH_SHORT).show();
                        interstitialvitoria3 = null;
                    }
                });

        InterstitialAd.load(this, getString(R.string.interstitial_vitoria4), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialvitoria4 = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Toast.makeText(Placar.this, "Falha na apresentação da propaganda.", Toast.LENGTH_SHORT).show();
                        interstitialvitoria4 = null;
                    }
                });

        InterstitialAd.load(this, getString(R.string.interstitial_vitoria5), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialvitoria5 = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Toast.makeText(Placar.this, "Falha na apresentação da propaganda.", Toast.LENGTH_SHORT).show();
                        interstitialvitoria5 = null;
                    }
                });

        InterstitialAd.load(this, getString(R.string.interstitial_vitoria6), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialvitoria6 = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Toast.makeText(Placar.this, "Falha na apresentação da propaganda.", Toast.LENGTH_SHORT).show();
                        interstitialvitoria6 = null;
                    }
                });

        InterstitialAd.load(this, getString(R.string.interstitial_vitoria7), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialvitoria7 = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Toast.makeText(Placar.this, "Falha na apresentação da propaganda.", Toast.LENGTH_SHORT).show();
                        interstitialvitoria7 = null;
                    }
                });

        InterstitialAd.load(this, getString(R.string.interstitial_vitoria8), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        interstitialvitoria8 = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Toast.makeText(Placar.this, "Falha na apresentação da propaganda.", Toast.LENGTH_SHORT).show();
                        interstitialvitoria8 = null;
                    }
                });


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(TotalPontosPref)) {
            bindingplacar.edtValorPlacar.setText(sharedpreferences.getString(TotalPontosPref, ""));
        }
        if (sharedpreferences.contains(TimeAPref)) {
            bindingplacar.edtTimeA.setText(sharedpreferences.getString(TimeAPref, ""));
        }
        if (sharedpreferences.contains(TimeBPref)) {
            bindingplacar.edtTimeB.setText(sharedpreferences.getString(TimeBPref, ""));
        }
        if (sharedpreferences.contains(PlacarTimeAPref)) {
            bindingplacar.edtPlacarTimeA.setText(sharedpreferences.getString(PlacarTimeAPref, ""));
        }
        if (sharedpreferences.contains(PlacarTimeBPref)) {
            bindingplacar.edtPlacarTimeB.setText(sharedpreferences.getString(PlacarTimeBPref, ""));
        }
        if (sharedpreferences.contains(placarSetAPref)) {
            bindingplacar.txtSetTimeA.setText(sharedpreferences.getString(placarSetAPref, ""));
        }
        if (sharedpreferences.contains(placarSetBPref)) {
            bindingplacar.txtSetTimeB.setText(sharedpreferences.getString(placarSetBPref, ""));
        }

        sharedTutorial = getSharedPreferences("LastSettingTuto", Context.MODE_PRIVATE);
        editorTutorial = sharedTutorial.edit();

        contadorturial = sharedTutorial.getInt("tutorial", 0);

        contadorturial++;

        editorTutorial.putInt("tutorial", contadorturial);
        editorTutorial.commit();

        tutorialValorPlacar();

        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                / View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    // Método hideSystemBars

    protected int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }

    public void seteA() {

        int setA = Integer.parseInt(bindingplacar.txtSetTimeA.getText().toString());
        int setB = Integer.parseInt(bindingplacar.txtSetTimeB.getText().toString());
        int setResult = setA - setB;
        int setResultModel = Math.abs(setResult);

        contseteA = Integer.parseInt(bindingplacar.txtSetTimeA.getText().toString());

        contseteA++;

        bindingplacar.txtSetTimeA.setText(String.valueOf(contseteA));

    }

    /*
    public void seteA() {

        int setA = Integer.parseInt(bindingplacar.txtSetTimeA.getText().toString());
        int setB = Integer.parseInt(bindingplacar.txtSetTimeB.getText().toString());
        int setResult = setA - setB;
        int setResultModel = Math.abs(setResult);

        contseteA = Integer.parseInt(bindingplacar.txtSetTimeA.getText().toString());

        contseteA++;

        bindingplacar.txtSetTimeA.setText(String.valueOf(contseteA));

        if (contseteA == 3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.title_vitoriadapartida)
                    .setMessage(R.string.msg_jogoganho)
                    .setCancelable(true)
                    .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            bindingplacar.txtSetTimeA.setText("00");
                            bindingplacar.txtSetTimeB.setText("00");

                            zeraPlacarAlto();
                            salvePrefTimeAB();

                            contseteA = 0;
                            contseteB = 0;

                        }
                    })
                    .create()
                    .show();
        }
    }*/

    public void seteB() {

        int setA = Integer.parseInt(bindingplacar.txtSetTimeA.getText().toString());
        int setB = Integer.parseInt(bindingplacar.txtSetTimeB.getText().toString());
        int setResult = setA - setB;
        int setResultModel = Math.abs(setResult);

        contseteB = Integer.parseInt(bindingplacar.txtSetTimeB.getText().toString());

        contseteB++;

        bindingplacar.txtSetTimeB.setText(String.valueOf(contseteB));

    }

    public void NumeroDePontos() {
        int totalDePontos = Integer.parseInt(bindingplacar.edtValorPlacar.getText().toString());
        if (totalDePontos == 00) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.title_numpontos)
                    .setMessage(R.string.msg_numpontos)
                    .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            bindingplacar.edtValorPlacar.requestFocus();
                        }
                    })
                    .create()
                    .show();

        }
    }

    public void salvePrefTimeAB() {
        String totalpontos = bindingplacar.edtValorPlacar.getText().toString();
        String timaA = bindingplacar.edtTimeA.getText().toString();
        String timeB = bindingplacar.edtTimeB.getText().toString();
        String placartimeA = bindingplacar.edtPlacarTimeA.getText().toString();
        String placartimeB = bindingplacar.edtPlacarTimeB.getText().toString();
        String placaSetA = bindingplacar.txtSetTimeA.getText().toString();
        String placarSetB = bindingplacar.txtSetTimeB.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(TotalPontosPref, totalpontos);
        editor.putString(TimeAPref, timaA);
        editor.putString(TimeBPref, timeB);
        editor.putString(PlacarTimeAPref, placartimeA);
        editor.putString(PlacarTimeBPref, placartimeB);
        editor.putString(placarSetAPref, placaSetA);
        editor.putString(placarSetBPref, placarSetB);

        editor.commit();
    }

    public void MaisUmPontoTimeA(View view) {

        bindingplacar.edtValorPlacar.setEnabled(false);

        salvePrefTimeAB();

        valorTotalPontos = Integer.parseInt(bindingplacar.edtValorPlacar.getText().toString());

        diferencaplaca = placaA - placaB;
        diferencaplacamodel = Math.abs(diferencaplaca);

        if (bindingplacar.checkDiferen2.isChecked()) {

            if (placaA < valorTotalPontos) {
                placaA++;
            } else if (placaA == valorTotalPontos & diferencaplacamodel < 2) {
                placaA++;
            } else if (placaA > valorTotalPontos & diferencaplacamodel < 2) {
                placaA++;
            }

            diferencaplaca = placaA - placaB;
            diferencaplacamodel = Math.abs(diferencaplaca);

            if (placaA > valorTotalPontos & diferencaplacamodel == 2) {
                seteA();
                contseteA = Integer.parseInt(bindingplacar.txtSetTimeA.getText().toString());

                if (contseteA == 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoriadapartida)
                            .setMessage(R.string.msg_jogoganho)
                            .setCancelable(true)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    bindingplacar.txtSetTimeA.setText("00");
                                    bindingplacar.txtSetTimeB.setText("00");

                                    zeraPlacarAlto();
                                    salvePrefTimeAB();

                                    contseteA = 0;
                                    contseteB = 0;

                                }
                            })
                            .create()
                            .show();
                } else if (contseteA != 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoria)
                            .setMessage(R.string.msg_timevencedor)
                            .setCancelable(false)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    zeraPlacarAlto();
                                    salvePrefTimeAB();

                                    showPropaganda();
                                }
                            })
                            .create()
                            .show();
                }

            } else if (placaA == valorTotalPontos & diferencaplacamodel >= 2) {
                seteA();
                contseteA = Integer.parseInt(bindingplacar.txtSetTimeA.getText().toString());

                if (contseteA == 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoriadapartida)
                            .setMessage(R.string.msg_jogoganho)
                            .setCancelable(true)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    bindingplacar.txtSetTimeA.setText("00");
                                    bindingplacar.txtSetTimeB.setText("00");

                                    zeraPlacarAlto();
                                    salvePrefTimeAB();

                                    contseteA = 0;
                                    contseteB = 0;

                                }
                            })
                            .create()
                            .show();
                } else if (contseteA != 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoria)
                            .setMessage(R.string.msg_timevencedor)
                            .setCancelable(false)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    salvePrefTimeAB();
                                    zeraPlacarAlto();

                                    showPropaganda();
                                }
                            })
                            .create()
                            .show();
                }

            }

        } else {
            if (placaA < valorTotalPontos) {
                placaA++;
            }
            if (placaA == valorTotalPontos & placaB < placaA) {
                seteA();
                contseteA = Integer.parseInt(bindingplacar.txtSetTimeA.getText().toString());
                if (contseteA == 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoriadapartida)
                            .setMessage(R.string.msg_jogoganho)
                            .setCancelable(true)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    bindingplacar.txtSetTimeA.setText("00");
                                    bindingplacar.txtSetTimeB.setText("00");

                                    zeraPlacarAlto();
                                    salvePrefTimeAB();

                                    contseteA = 0;
                                    contseteB = 0;

                                }
                            })
                            .create()
                            .show();
                } else if (contseteA != 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoria)
                            .setMessage(R.string.msg_timevencedor)
                            .setCancelable(false)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    salvePrefTimeAB();
                                    zeraPlacarAlto();

                                    showPropaganda();
                                }
                            })
                            .create()
                            .show();
                }

            }

        }

        bindingplacar.edtPlacarTimeA.setText(String.valueOf(placaA));

        if (placaA > 0 || placaB > 0) {
            bindingplacar.constraintLayout3.setVisibility(View.GONE);
        } else if (placaA == 0 & placaB == 0) {
            bindingplacar.constraintLayout3.setVisibility(View.VISIBLE);
        }
    }

    public void MaisUmPontoTimeB(View view) {

        bindingplacar.edtValorPlacar.setEnabled(false);

        salvePrefTimeAB();

        valorTotalPontos = Integer.parseInt(bindingplacar.edtValorPlacar.getText().toString());

        diferencaplaca = placaA - placaB;
        diferencaplacamodel = Math.abs(diferencaplaca);

        if (bindingplacar.checkDiferen2.isChecked()) {
            if (placaB < valorTotalPontos) {
                placaB++;
            } else if (placaB == valorTotalPontos & diferencaplacamodel < 2) {
                placaB++;
            } else if (placaB > valorTotalPontos & diferencaplacamodel < 2) {
                placaB++;

            }

            diferencaplaca = placaA - placaB;
            diferencaplacamodel = Math.abs(diferencaplaca);

            if (placaB > valorTotalPontos & diferencaplacamodel == 2) {
                seteB();
                contseteB = Integer.parseInt(bindingplacar.txtSetTimeB.getText().toString());

                if (contseteB == 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoriadapartida)
                            .setMessage(R.string.msg_jogoganho)
                            .setCancelable(true)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    bindingplacar.txtSetTimeA.setText("00");
                                    bindingplacar.txtSetTimeB.setText("00");

                                    zeraPlacarAlto();
                                    salvePrefTimeAB();

                                    contseteA = 0;
                                    contseteB = 0;


                                }
                            })
                            .create()
                            .show();

                } else if (contseteB != 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoria)
                            .setMessage(R.string.msg_timevencedorB)
                            .setCancelable(false)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    salvePrefTimeAB();

                                    showPropaganda();
                                }
                            })
                            .create()
                            .show();
                }

            } else if (placaB == valorTotalPontos & diferencaplacamodel >= 2) {
                seteB();
                contseteB = Integer.parseInt(bindingplacar.txtSetTimeB.getText().toString());

                if (contseteB == 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoriadapartida)
                            .setMessage(R.string.msg_jogoganho)
                            .setCancelable(true)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    bindingplacar.txtSetTimeA.setText("00");
                                    bindingplacar.txtSetTimeB.setText("00");

                                    zeraPlacarAlto();
                                    salvePrefTimeAB();

                                    contseteA = 0;
                                    contseteB = 0;


                                }
                            })
                            .create()
                            .show();

                } else if (contseteB != 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoria)
                            .setMessage(R.string.msg_timevencedorB)
                            .setCancelable(false)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    salvePrefTimeAB();
                                    zeraPlacarAlto();

                                    showPropaganda();
                                }
                            })
                            .create()
                            .show();
                }

            }

        } else {
            if (placaB < valorTotalPontos) {
                placaB++;
            }
            if (placaB == valorTotalPontos & placaA < placaB) {
                seteB();
                contseteB = Integer.parseInt(bindingplacar.txtSetTimeB.getText().toString());

                if (contseteB == 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoriadapartida)
                            .setMessage(R.string.msg_jogoganho)
                            .setCancelable(true)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    bindingplacar.txtSetTimeA.setText("00");
                                    bindingplacar.txtSetTimeB.setText("00");

                                    zeraPlacarAlto();
                                    salvePrefTimeAB();

                                    contseteA = 0;
                                    contseteB = 0;


                                }
                            })
                            .create()
                            .show();

                } else if (contseteB != 3) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(R.string.title_vitoria)
                            .setMessage(R.string.msg_timevencedorB)
                            .setCancelable(false)
                            .setPositiveButton(R.string.alert_btn_ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    salvePrefTimeAB();
                                    zeraPlacarAlto();
                                    showPropaganda();
                                }
                            })
                            .create()
                            .show();
                }
            }
        }

        bindingplacar.edtPlacarTimeB.setText(String.valueOf(placaB));

        if (placaA > 0 || placaB > 0) {
            bindingplacar.constraintLayout3.setVisibility(View.GONE);
        } else if (placaA == 0 & placaB == 0) {
            bindingplacar.constraintLayout3.setVisibility(View.VISIBLE);
        }

    }

    public void MenosUmPontoTimeA(View view) {

        if (placaA > 0) {
            placaA--;
        }

        bindingplacar.edtPlacarTimeA.setText(String.valueOf(placaA));

        if (placaA > 0 || placaB > 0) {
            bindingplacar.constraintLayout3.setVisibility(View.GONE);
        } else if (placaA == 0 & placaB == 0) {
            bindingplacar.constraintLayout3.setVisibility(View.VISIBLE);
            bindingplacar.edtValorPlacar.setEnabled(true);
        }
    }

    public void MenosUmPontoTimeB(View view) {
        if (placaB > 0) {
            placaB--;
        }
        bindingplacar.edtPlacarTimeB.setText(String.valueOf(placaB));

        if (placaA > 0 || placaB > 0) {
            bindingplacar.constraintLayout3.setVisibility(View.GONE);
        } else if (placaA == 0 & placaB == 0) {
            bindingplacar.constraintLayout3.setVisibility(View.VISIBLE);
            bindingplacar.edtValorPlacar.setEnabled(true);
        }

    }

    public void zeraPlacar(View view) {

        bindingplacar.edtValorPlacar.setEnabled(true);

        bindingplacar.edtPlacarTimeA.setText("0");
        bindingplacar.edtPlacarTimeB.setText("0");

        placaA = 0;
        placaB = 0;

        String totalpontos = bindingplacar.edtValorPlacar.getText().toString();
        String timaA = bindingplacar.edtTimeA.getText().toString();
        String timeB = bindingplacar.edtTimeB.getText().toString();
        String placartimeA = bindingplacar.edtPlacarTimeA.getText().toString();
        String placartimeB = bindingplacar.edtPlacarTimeB.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(TotalPontosPref, totalpontos);
        editor.putString(TimeAPref, timaA);
        editor.putString(TimeBPref, timeB);
        editor.putString(PlacarTimeAPref, placartimeA);
        editor.putString(PlacarTimeBPref, placartimeB);

        editor.commit();

        bindingplacar.constraintLayout3.setVisibility(View.VISIBLE);

    }

    public void zeraPlacarAlto() {

        bindingplacar.edtValorPlacar.setEnabled(true);

        bindingplacar.edtPlacarTimeA.setText("0");
        bindingplacar.edtPlacarTimeB.setText("0");

        placaA = 0;
        placaB = 0;

        String totalpontos = bindingplacar.edtValorPlacar.getText().toString();
        String timaA = bindingplacar.edtTimeA.getText().toString();
        String timeB = bindingplacar.edtTimeB.getText().toString();
        String placartimeA = bindingplacar.edtPlacarTimeA.getText().toString();
        String placartimeB = bindingplacar.edtPlacarTimeB.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(TotalPontosPref, totalpontos);
        editor.putString(TimeAPref, timaA);
        editor.putString(TimeBPref, timeB);
        editor.putString(PlacarTimeAPref, placartimeA);
        editor.putString(PlacarTimeBPref, placartimeB);

        editor.commit();

        bindingplacar.constraintLayout3.setVisibility(View.VISIBLE);

    }

    public void enviarEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.setData(Uri.parse("mailto:"));
        intent.setType("text/text");
        intent.putExtra(Intent.EXTRA_TEXT, "MarcarOsPontos,  placar para marcar os pontos da sua pelada de vôlei, link para download -> https://play.google.com/store/apps/details?id=com.lalp.sist.marcaoponto");

        startActivity(intent);
    }

 /*   public void showPropaganda(){

        contadorads++;

        if (contadorads == 4){
            Intent it = new Intent(Placar.this, Placar.class);
            ((AppCompatActivity) Placar.this).startActivity(it);

            contadorads = contadorads - 3;

            if (interstitialzeraplacar != null) {
                interstitialzeraplacar.show(Placar.this);
            } else {
                Toast.makeText(Placar.this, "Falha na apresentação da propaganda.", Toast.LENGTH_SHORT).show();
            }

        }
    }*/

    public void showPropaganda() {
        contadorads++;

        if (contadorads == 10) {
            System.out.println("Contador: " + contadorads);
            if (interstitialvitoria != null) {
                interstitialvitoria.show(Placar.this);
            }
        } else if (contadorads == 18) {
            System.out.println("Contador: " + contadorads);
            if (interstitialvitoria2 != null) {
                interstitialvitoria2.show(Placar.this);
            }
        } else if (contadorads == 26) {
            System.out.println("Contador: " + contadorads);
            if (interstitialvitoria3 != null) {
                interstitialvitoria3.show(Placar.this);
            }
        } else if (contadorads == 34) {
            System.out.println("Contador: " + contadorads);
            if (interstitialvitoria4 != null) {
                interstitialvitoria4.show(Placar.this);
            }
        } else if (contadorads == 42) {
            System.out.println("Contador: " + contadorads);
            if (interstitialvitoria5 != null) {
                interstitialvitoria5.show(Placar.this);
            }
        } else if (contadorads == 50) {
            System.out.println("Contador: " + contadorads);
            if (interstitialvitoria6 != null) {
                interstitialvitoria6.show(Placar.this);
            }
        } else if (contadorads == 58) {
            System.out.println("Contador: " + contadorads);
            if (interstitialvitoria7 != null) {
                interstitialvitoria7.show(Placar.this);
            }
        } else if (contadorads == 63) {
            System.out.println("Contador: " + contadorads);
            contadorads = 0;
            if (interstitialvitoria8 != null) {
                interstitialvitoria8.show(Placar.this);
            }
        }
    }

    public void tutorialValorPlacar() {

        if (contadorturial == 1) {

            TapTargetView.showFor(this,
                    TapTarget.forView(bindingplacar.edtValorPlacar, "Total de pontos do placar", "Campo para informar a quantidade de pontos do jogo." +
                                    "Click no círculo para desativa o informativo")
                            .outerCircleColor(R.color.purple_200)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(20)
                            .titleTextColor(R.color.black)
                            .descriptionTextSize(13)
                            .descriptionTextColor(R.color.white)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.white)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                            .targetRadius(30),
                    new TapTargetView.Listener() {
                        @Override
                        public void onTargetClick(TapTargetView view) {
                            super.onTargetClick(view);

                            contadorturial++;

                            editorTutorial.putInt("tutorial", contadorturial);
                            editorTutorial.commit();

                            tutorialAddPonto();

                        }
                    });

        } else {
            NumeroDePontos();
        }
    }

    //Tutoriais de uso para uso inicial
    public void tutorialAddPonto() {

        if (contadorturial == 2) {

            TapTargetView.showFor(this,
                    TapTarget.forView(bindingplacar.btnMaisUmA, "Adicionar Ponto", "Click na parte superior do placar para adicionar pontos." +
                                    "Click no círculo para desativa o informativo")
                            .outerCircleColor(R.color.purple_500)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(20)
                            .titleTextColor(R.color.black)
                            .descriptionTextSize(13)
                            .descriptionTextColor(R.color.white)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.white)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                            .targetRadius(50),
                    new TapTargetView.Listener() {
                        @Override
                        public void onTargetClick(TapTargetView view) {
                            super.onTargetClick(view);

                            contadorturial++;

                            editorTutorial.putInt("tutorial", contadorturial);
                            editorTutorial.commit();

                            tutorialMenosPonto();

                        }
                    });

        }
    }

    public void tutorialMenosPonto() {

        if (contadorturial == 3) {

            TapTargetView.showFor(this,
                    TapTarget.forView(bindingplacar.btnMenosUmA, "Reduzir Ponto", "Click na parte inferior do placa para reduzir os pontos." +
                                    "Click no círculo para desativa o informativo")
                            .outerCircleColor(R.color.purple_500)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(20)
                            .titleTextColor(R.color.black)
                            .descriptionTextSize(13)
                            .descriptionTextColor(R.color.white)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.white)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                            .targetRadius(50),
                    new TapTargetView.Listener() {
                        @Override
                        public void onTargetClick(TapTargetView view) {
                            super.onTargetClick(view);

                            contadorturial++;

                            editorTutorial.putInt("tutorial", contadorturial);
                            editorTutorial.commit();

                        }
                    });

        }
    }

}