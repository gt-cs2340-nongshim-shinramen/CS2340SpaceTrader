package com.example.m6.views;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.m6.R;
import com.example.m6.model.Goods;
import com.example.m6.model.Player;
import com.example.m6.model.Resource;
public class SellGoodsActivity extends AppCompatActivity implements SellDialog.SellDialogListener {
    Player player;
    TextView waterPrice, furPrice, foodPrice, orePrice, firearmPrice, gamePrice, medicinePrice, machinePrice, narcorticsPrice, robotPrice;
    int water, fur, food, ore, firearm, game, medicine, machine, narcortics, robot;
    TextView credit, bay;
    Button sell_water, sell_furs, sell_food, sell_ore, sell_firearms, sell_games, sell_medicine, sell_machines, sell_narcotics, sell_robots;
    Button waterMax, furMax, foodMax, oreMax, firearmMax, gameMax, medicineMax, machineMax, narcorticsMax, robotMax;
    String inputStr = "0";
    Button menuButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_goods);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        player = (Player)getIntent().getSerializableExtra("player");
        Log.d("player", player.getName()+" is into SellActivity sucessfully" );

        menuButton = findViewById(R.id.sell_menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenu();
            }
        });



        credit = findViewById(R.id.sell_credit);
        credit.setText(String.valueOf(player.getCredit())+" Cr");
        bay = findViewById(R.id.sell_bays);
        bay.setText(String.valueOf(player.getCargo())+"/"+player.getSpaceship().getBay());
        setupPrice();
        waterMax = findViewById(R.id.sell_all_water);
        clickMaxButton(waterMax, water, Goods.WATER);
        furMax = findViewById(R.id.sell_all_furs);
        clickMaxButton(furMax, fur, Goods.FURS);
        foodMax = findViewById(R.id.sell_all_food);
        clickMaxButton(foodMax, food, Goods.FOOD);
        oreMax = findViewById(R.id.sell_all_ore);
        clickMaxButton(oreMax, ore, Goods.ORE);
        firearmMax = findViewById(R.id.sell_all_firearms);
        clickMaxButton(firearmMax, firearm, Goods.FIREARMS);
        gameMax = findViewById(R.id.sell_all_games);
        clickMaxButton(gameMax, game, Goods.GAMES);
        medicineMax = findViewById(R.id.sell_all_medicine);
        clickMaxButton(medicineMax, medicine, Goods.MEDICINE);
        machineMax = findViewById(R.id.sell_all_machines);
        clickMaxButton(machineMax, machine, Goods.MACHINES);
        narcorticsMax = findViewById(R.id.dump_all_narcotics);
        clickMaxButton(narcorticsMax, narcortics, Goods.NARCOTICS);
        robotMax = findViewById(R.id.sell_all_robots);
        clickMaxButton(robotMax, robot, Goods.ROBOTS);
        sell_water =findViewById(R.id.sell_num_water);
        clickNumButton(sell_water, water, Goods.WATER);
        sell_furs =findViewById(R.id.sell_num_furs);
        clickNumButton(sell_furs, fur, Goods.FURS);
        sell_food =findViewById(R.id.sell_num_food);
        clickNumButton(sell_food, food, Goods.FOOD);
        sell_ore =findViewById(R.id.sell_num_ore);
        clickNumButton(sell_ore, ore, Goods.ORE);
        sell_firearms =findViewById(R.id.sell_num_firearms);
        clickNumButton(sell_firearms, firearm, Goods.FIREARMS);
        sell_games =findViewById(R.id.sell_num_games);
        clickNumButton(sell_games, game, Goods.GAMES);
        sell_medicine =findViewById(R.id.sell_num_medicine);
        clickNumButton(sell_medicine, medicine, Goods.MEDICINE);
        sell_machines =findViewById(R.id.sell_num_machines);
        clickNumButton(sell_machines, machine, Goods.MACHINES);
        sell_narcotics =findViewById(R.id.sell_num_narcotics);
        clickNumButton(sell_narcotics, narcortics, Goods.NARCOTICS);
        sell_robots =findViewById(R.id.sell_num_robots);
        clickNumButton(sell_robots, robot, Goods.ROBOTS);

        setupInverntory();


    }
    public void setupInverntory(){
        sell_water.setText(String.valueOf(player.getInven().get("water".toLowerCase())));
        sell_furs.setText(String.valueOf(player.getInven().get("furs".toLowerCase())));
        sell_food.setText(String.valueOf(player.getInven().get("food".toLowerCase())));
        sell_ore.setText(String.valueOf(player.getInven().get("ore".toLowerCase())));
        sell_firearms.setText(String.valueOf(player.getInven().get("firearms".toLowerCase())));
        sell_medicine.setText(String.valueOf(player.getInven().get("medicine".toLowerCase())));
        sell_games.setText(String.valueOf(player.getInven().get("games".toLowerCase())));
        sell_machines.setText(String.valueOf(player.getInven().get("machines".toLowerCase())));
        sell_narcotics.setText(String.valueOf(player.getInven().get("narcotics".toLowerCase())));
        sell_robots.setText(String.valueOf(player.getInven().get("robots".toLowerCase())));
    }
    public void clickMaxButton(Button button, final int price, final Goods goods) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IsAble(goods)) {
                    int max = player.getInven().get(goods.toString().toLowerCase());
                    if (max > 0) {
                        player.getInven().put(goods.toString().toLowerCase(), 0);
                        player.setCargo(player.getCargo() - max);
                        player.setCredit(player.getCredit() + max * price);
                        bay.setText(String.valueOf(player.getCargo()) + "/" + player.getSpaceship().getBay());
                        credit.setText(String.valueOf(player.getCredit()) + " Cr");
                        setupInverntory();

                        Toast.makeText(getApplicationContext(), "You sold " + max + " " + goods.toString(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "You can not sell anymore. Check your bay.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    openAlert();
                }
            }
        });
    }
    public void clickNumButton(Button button, final int price, final Goods goods){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(IsAble(goods)){
                    openSell(goods.toString(), price);
                } else {
                    openAlert();
                }
            }
        });
    }
    public int calculatePrice(Goods goods){
        int resource = player.getCurrentplanet().getResource();
        int price = goods.getBasePrice() + goods.getIPL()*(player.getCurrentplanet().getTechLevel() - goods.getMTLU());
        boolean head = (Math.random() < 0.5);
        if (head) {
            price +=goods.getBasePrice()*((int)(Math.random()*goods.getVar())/100);
        } else {
            price -= goods.getBasePrice()*((int)(Math.random()*goods.getVar())/100);
        }
        if (goods.equals(Goods.WATER)) {
            if (resource==Resource.DROUGHT.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.LOTSOFWATER.getNumber()) {
                price = price / 3;
            }
            if (resource==Resource.DESERT.getNumber()) {
                price = price * 2;
            }
        }
        if (goods.equals(Goods.FURS)) {
            if (resource==Resource.COLD.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.RICHFAUNA.getNumber()) {
                price = price / 3;
            }
            if (resource==Resource.LIFELESS.getNumber()) {
                price = price * 2;
            }
        }
        if (goods.equals(Goods.FOOD)) {
            if (resource==Resource.CROPFAIL.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.RICHSOIL.getNumber()) {
                price = price / 3;
            }
            if (resource==Resource.POORSOIL.getNumber()) {
                price = price * 2;
            }
        }
        if (goods.equals(Goods.ORE)) {
            if (resource==Resource.MINERALRICH.getNumber()) {
                price = price / 3;
            }
            if (resource==Resource.MINERALPOOR.getNumber()) {
                price = price * 2;
            }
        }
        if (goods.equals(Goods.GAMES)) {
            if (resource==Resource.BOREDOM.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.ARTISTIC.getNumber()) {
                price = price / 3;
            }
        }
        if (goods.equals(Goods.FIREARMS)) {
            if (resource==Resource.WAR.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.WARLIKE.getNumber()) {
                price = price / 3;
            }
        }
        if (goods.equals(Goods.MEDICINE)) {
            if (resource==Resource.PLAGUE.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.LOTSOFHERBS.getNumber()) {
                price = price / 3;
            }
        }
        if (goods.equals(Goods.MACHINES)) {
            if (resource==Resource.LACKOFWORKERS.getNumber()) {
                price = price * 3;
            }
        }
        if (goods.equals(Goods.NARCOTICS)) {
            if (resource==Resource.LACKOFWORKERS.getNumber()) {
                price = price * 3;
            }
            if (resource==Resource.WEIRDMUSHROOMS.getNumber()) {
                price = price / 3;
            }
        }
        if (goods.equals(Goods.ROBOTS)) {
            if (resource==Resource.LACKOFWORKERS.getNumber()) {
                price = price * 3;
            }
        }
        return price;
    }
    public void setupPrice() {
        String price;
        waterPrice = findViewById(R.id.sell_price_water);
        if (IsAble(Goods.WATER)){
            water = calculatePrice(Goods.WATER);
            price = water + " cr";
        }
        else {
            price = "N/A";
        }
        waterPrice.setText(price);
        furPrice = findViewById(R.id.sell_price_furs);
        if (IsAble(Goods.FURS)){
            fur = calculatePrice(Goods.FURS);
            price = fur + " cr";
        }  else {
            price = "N/A";
        }
        furPrice.setText(price);
        foodPrice = findViewById(R.id.sell_price_food);
        if (IsAble(Goods.FOOD)) {
            food = calculatePrice(Goods.FOOD);
            price = food +" cr";
        } else {
            price = "N/A";
        }
        foodPrice.setText(price);
        orePrice = findViewById(R.id.sell_price_ore);
        if (IsAble(Goods.ORE)) {
            ore = calculatePrice(Goods.ORE);
            price = ore + " cr";
        } else {
            price = "N/A";
        }
        orePrice.setText(price);
        gamePrice = findViewById(R.id.sell_price_games);
        if (IsAble(Goods.GAMES)) {
            game = calculatePrice(Goods.GAMES);
            price = game +" cr";
        } else {
            price = "N/A";
        }
        gamePrice.setText(price);
        firearmPrice = findViewById(R.id.sell_price_firearms);
        if (IsAble(Goods.FIREARMS)) {
            firearm = calculatePrice(Goods.FIREARMS);
            price = firearm+" cr";
        } else {
            price = "N/A";
        }
        firearmPrice.setText(price);
        medicinePrice = findViewById(R.id.sell_price_medicine);
        if (IsAble(Goods.MEDICINE)){
            medicine = calculatePrice(Goods.MEDICINE);
            price = medicine + " cr";
        } else {
            price = "N/A";
        }
        medicinePrice.setText(price);
        machinePrice = findViewById(R.id.sell_price_machines);
        if (IsAble(Goods.MACHINES)) {
            machine = calculatePrice(Goods.MACHINES);
            price = machine +" cr";
        } else {
            price = "N/A";
        }
        machinePrice.setText(price);
        narcorticsPrice = findViewById(R.id.sell_price_narcotics);
        if (IsAble(Goods.NARCOTICS)){
            narcortics = calculatePrice(Goods.NARCOTICS);
            price = narcortics+ " cr";
        } else {
            price = "N/A";
        }
        narcorticsPrice.setText(price);
        robotPrice = findViewById(R.id.sell_price_robots);
        if (IsAble(Goods.ROBOTS)){
            robot = calculatePrice(Goods.ROBOTS);
            price = robot +" cr";
        } else {
            price = "N/A";
        }
        robotPrice.setText(price);
    }
    boolean IsAble(Goods goods) {
        return (player.getCurrentplanet().getTechLevel() - goods.getMTLU() < 0)? false : true;
    }
    public void openAlert(){
        AlertWindow alert = new AlertWindow();
        alert.show(getSupportFragmentManager(), "alert");
    }
    public void openSell(String goods, int price) {
        DialogFragment frag = new SellDialog();
        Bundle bundle = new Bundle();
        bundle.putString("goodstype", goods);
        bundle.putInt("price", price);
        frag.setArguments(bundle);
        frag.show(getSupportFragmentManager(), "dialog");
    }
    @Override
    public void onInputData(String input) {
        Toast.makeText(this, input+" items sold.", Toast.LENGTH_LONG).show();
        inputStr =(input);
    }
    @Override
    public void sellItem(String goods, int price) {
        //inputStr is input number as string value
        int max = player.getInven().get(goods.toLowerCase());
        if (max-Integer.parseInt(inputStr) >= 0) {
            player.getInven().put(goods.toLowerCase(), player.getInven().get(goods.toLowerCase())-Integer.parseInt(inputStr));
            player.setCargo(player.getCargo() - Integer.parseInt(inputStr));
            player.setCredit(player.getCredit() + Integer.parseInt(inputStr) * price);
            bay.setText(String.valueOf(player.getCargo()) + "/" + player.getSpaceship().getBay());
            credit.setText(String.valueOf(player.getCredit()) + " Cr");
            setupInverntory();
            Toast.makeText(getApplicationContext(), "You sold " + inputStr + " " + goods, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "You can not sell anymore. Check your bay.", Toast.LENGTH_LONG).show();
        }
    }
    public void openMenu() {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("player", player);
        Log.d("player", player.getName()+" sent from SellGoodsActivity to MenuActivity sucessfully" );
        startActivity(intent);
    }
}