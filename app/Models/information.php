<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Facades\DB;

class information extends Model
{
    use HasFactory;
    protected $table = 'information';
    protected $fillable=['idinf', 'titre', 'sous_titre', 'date', 'description', 'idimage', 'idcategorie'];
    

    public function insertInfo($titre, $sous_titre, $description, $idimage, $idcategorie){
        $data = array('titre' => $titre, 'sous_titre' => $sous_titre, 'description' => $description, 'idimage' => $idimage, 'idcategorie' => $idcategorie);
        DB::table('information')->insert($data);
    }

    // public function image(){
    //     return $this->belongsTo(image::class, 'idimage');
    // }
    
}
