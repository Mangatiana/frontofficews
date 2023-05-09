<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\usera;
use App\Models\categorie;

class useraController extends Controller
{
    public function connect(Request $request){
        $user = $request->input('user');
        $mdp = $request->input('mdp');
        $usr = usera::where('nom', $user)->where('mdp', $mdp)->first();
        $categorie = new categorie();
        $listCat = $categorie->listerCategorie();
        if(!is_null($usr)){
            return view('insertion', compact('listCat'));
        } else {
            return view('login');
        }
        
    }
}
