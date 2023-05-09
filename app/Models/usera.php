<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class usera extends Model
{
    use HasFactory;
    protected $table = 'usera';

    public function check(){
        $liste = categorie::orderBy("idcategorie","asc")->get();
        return $liste;
    }
}
