<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Support\Facades\DB;

class image extends Model
{
    use HasFactory;
    protected $table = 'image';
    protected $fillable=['idimage', 'base', 'legende', 'source'];
    
    public function insertImage($image, $legende, $source){
        $data = array('base' => $image, 'legende' => $legende, 'source' => $source);
        DB::table('image')->insert($data);
    }

    public function selectLastIdImage(){
        $img = image::orderBy("idimage","desc")->first();
        return $img;
    }
}
