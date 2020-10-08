<template>
  <!-- Dùng cho kiểm tra lực phanh -->
  <div>
    <v-layout row wrap class="ml-0">
      <v-flex xs12 sm3>
        <label class="content-label">Đăng kiểm viên 1:&nbsp;</label>
      </v-flex>
      <v-flex xs12 sm9>
        <v-select
          class="my-0 py-0"
          :items="dangKiemVienItems"
          item-text="fullName"
          item-value="userId"
          v-model="thietBiKiemTra['dang_kiem_vien_1']"
        ></v-select>
      </v-flex>

      <v-flex xs12 sm3>
        <label class="content-label">Đăng kiểm viên phối hợp:&nbsp;</label>
      </v-flex>
      <v-flex xs12 sm9>
        <v-select
          class="my-0 py-0"
          :items="dangKiemVienItems"
          item-text="fullName"
          item-value="userId"
          v-model="thietBiKiemTra['dang_kiem_vien_2']"
        ></v-select>
      </v-flex>

      <v-flex xs12 sm3>
        <label class="content-label">Số Báo cáo đánh giá:&nbsp;</label>
      </v-flex>
      <v-flex xs12 sm9>
        <v-text-field
          class="my-0 py-0"
          v-model="thietBiKiemTra['copReportNo']"
        ></v-text-field>
      </v-flex>

      <v-flex xs12 sm3>
        <label class="content-label">Ngày kiểm tra (từ):&nbsp;</label>
      </v-flex>
      <v-flex xs12 sm9>
        <v-text-field
          class="my-0 py-0"
          v-model="thietBiKiemTra['copReportDateFrom']"
        ></v-text-field>
      </v-flex>

      <v-flex xs12 sm3>
        <label class="content-label">Đến ngày:&nbsp;</label>
      </v-flex>
      <v-flex xs12 sm9>
        <v-text-field
          class="my-0 py-0"
          v-model="thietBiKiemTra['copReportDateTo']"
        ></v-text-field>
      </v-flex>
      
    </v-layout>
    <div style="text-align: right;">
      <span class="pt-2 pr-2">Đơn vị đo:</span>
      <v-text-field
      style="float: right; max-width: 80px;"
      class="my-0 py-0"
      v-model="donVi"
      ></v-text-field>
    </div>
    <table style="width: 100%; border-collapse: collapse;" border="1" class="ftable" v-if="detailCOP['thiet_bi_xuat_xuong'] && detailCOP['thiet_bi_xuat_xuong']['length']"> 
    <thead>
      <tr>
       <th class="text-xs-center" rowspan="2" style="width: 3%">TT</th>
       <th class="text-xs-center" rowspan="2">Hạng mục kiểm tra</th>
       <th class="text-xs-center" rowspan="2">Thông số chuẩn</th>
       <th class="text-xs-center" colspan="3">Thông số đo</th>
       <th class="text-xs-center" rowspan="2">Đánh giá</th>
     </tr>
     <tr>
       <td class="text-xs-center" style="font-weight: bold;">
         Bên phải
       </td>
       <td class="text-xs-center" style="font-weight: bold;">
         Bên trái
       </td>
       <td class="text-xs-center" style="font-weight: bold;">
         Độ lệch
       </td>
     </tr>
   </thead>
   <tbody>
      <tr :style="{background: checkColorCop(thietBiKiemTra['resultMark'])}">
        <td class="text-xs-center">1</td>
        <td class="pl-2">Nhãn hiệu</td>
        <td colspan="2">
          <v-text-field
          disabled
          class="my-0 py-0"
          v-model="thietBiKiemTra['mark']"
          ></v-text-field>
        </td>
        <td colspan="2">
          <v-text-field
          class="my-0 py-0"
          v-model="thietBiKiemTra['markTest']"
          ></v-text-field>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" :name="'result' + 1" class="check_radio" :id="'result_1' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultMark']">
            <label class="label-radio" :for="'result_1' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultModel'])}">
        <td class="text-xs-center">2</td>
        <td class="pl-2">Model:</td>
        <td colspan="2">
          <v-text-field
          disabled
          class="my-0 py-0"
          v-model="thietBiKiemTra['model']"
          ></v-text-field>
        </td>
        <td colspan="2">
          <v-text-field
          class="my-0 py-0"
          v-model="thietBiKiemTra['modelTest']"
          ></v-text-field>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" :name="'result' + 2" class="check_radio" :id="'result_2' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultModel']">
            <label class="label-radio" :for="'result_2' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultSeri'])}">
        <td class="text-xs-center">3</td>
        <td class="pl-2">Mã số Seri:</td>
        <td colspan="2">
          <v-text-field
          disabled
          class="my-0 py-0"
          v-model="thietBiKiemTra['seri']"
          ></v-text-field>
        </td>
        <td colspan="2">
          <v-text-field
          class="my-0 py-0"
          v-model="thietBiKiemTra['seriTest']"
          ></v-text-field>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" :name="'result' + 3" class="check_radio" :id="'result_3' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultSeri']">
            <label class="label-radio" :for="'result_3' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultYear'])}">
        <td class="text-xs-center">4</td>
        <td class="pl-2">Năm SX:</td>
        <td colspan="2">
          <v-text-field
          disabled
          class="my-0 py-0"
          v-model="thietBiKiemTra['year']"
          ></v-text-field>
        </td>
        <td colspan="2">
          <v-text-field
          class="my-0 py-0"
          v-model="thietBiKiemTra['yearTest']"
          ></v-text-field>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" :name="'result' + 4" class="check_radio" :id="'result_4' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultYear']">
            <label class="label-radio" :for="'result_4' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultCountry'])}">
        <td class="text-xs-center">5</td>
        <td class="pl-2">Nước SX:</td>
        <td colspan="2">
          <v-text-field
          disabled
          class="my-0 py-0"
          v-model="thietBiKiemTra['country']"
          ></v-text-field>
        </td>
        <td colspan="2">
          <v-text-field
          class="my-0 py-0"
          v-model="thietBiKiemTra['countryTest']"
          ></v-text-field>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" :name="'result' + 5" class="check_radio" :id="'result_5' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultCountry']">
            <label class="label-radio" :for="'result_5' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultStatus'])}">
        <td class="text-xs-center">6</td>
        <td class="pl-2">Tình trang hoạt động (1):</td>
        <td colspan="2">
          <v-text-field
          class="my-0 py-0"
          v-model="thietBiKiemTra['tinhTrangHoatDong']"
          ></v-text-field>
        </td>
        <td class="text-xs-center" colspan="2">
          <input type="radio" name="hoatdong" id="hoatdong" value="1" v-model="thietBiKiemTra['statusActive']">
          <label class="mr-3" for="hoatdong">Hoạt động</label>

          <input type="radio" name="hoatdong" id="khonghd" value="2" v-model="thietBiKiemTra['statusActive']">
          <label for="khonghd">Không hđ</label>
        </td>  
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" :name="'result' + 6" class="check_radio" :id="'result_6' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultStatus']">
            <label class="label-radio" :for="'result_6' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr>
        <td class="text-xs-center" rowspan="6">7</td>
        <td class="pl-2" rowspan="6">{{labelKiemTraMauCOP}}</td>
        <td :style="{background: checkColorCop(thietBiKiemTra['resultTest'][0]['result'])}">
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][0]['standardParameters']"
            ></v-text-field>
          </div>
        </td>
        <td :style="{background: checkColorCop(thietBiKiemTra['resultTest'][0]['result'])}">
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][0]['resultMeasurementLeft']"
            ></v-text-field>
          </div>
        </td>
        <td :style="{background: checkColorCop(thietBiKiemTra['resultTest'][0]['result'])}">
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][0]['resultMeasurementRight']"
            ></v-text-field>
          </div>
        </td>
        <td :style="{background: checkColorCop(thietBiKiemTra['resultTest'][0]['result'])}">
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][0]['resultDifferrence']"
            ></v-text-field>
          </div>
        </td>
        <td class="text-xs-center" :style="{background: checkColorCop(thietBiKiemTra['resultTest'][0]['result'])}" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" name="result7_1" class="check_radio" :id="'result_7_1' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultTest'][0]['result']">
            <label class="label-radio" :for="'result_7_1' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultTest'][1]['result'])}">
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][1]['standardParameters']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][1]['resultMeasurementLeft']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][1]['resultMeasurementRight']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][1]['resultDifferrence']"
            ></v-text-field>
          </div>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" name="result7_2" class="check_radio" :id="'result_7_2' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultTest'][1]['result']">
            <label class="label-radio" :for="'result_7_2' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultTest'][2]['result'])}">
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][2]['standardParameters']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][2]['resultMeasurementLeft']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][2]['resultMeasurementRight']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][2]['resultDifferrence']"
            ></v-text-field>
          </div>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" name="result7_3" class="check_radio" :id="'result_7_3' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultTest'][2]['result']">
            <label class="label-radio" :for="'result_7_3' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultTest'][3]['result'])}">
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][3]['standardParameters']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][3]['resultMeasurementLeft']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][3]['resultMeasurementRight']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][3]['resultDifferrence']"
            ></v-text-field>
          </div>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" name="result7_4" class="check_radio" :id="'result_7_4' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultTest'][3]['result']">
            <label class="label-radio" :for="'result_7_4' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultTest'][4]['result'])}">
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][4]['standardParameters']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][4]['resultMeasurementLeft']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][4]['resultMeasurementRight']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][4]['resultDifferrence']"
            ></v-text-field>
          </div>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" name="result7_5" class="check_radio" :id="'result_7_5' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultTest'][4]['result']">
            <label class="label-radio" :for="'result_7_5' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <tr :style="{background: checkColorCop(thietBiKiemTra['resultTest'][5]['result'])}">
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][5]['standardParameters']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][5]['resultMeasurementLeft']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][5]['resultMeasurementRight']"
            ></v-text-field>
          </div>
        </td>
        <td>
          <div style="display: flex;">
            <v-text-field
              class="my-0 py-0"
              v-model="thietBiKiemTra['resultTest'][5]['resultDifferrence']"
            ></v-text-field>
          </div>
        </td>
        <td class="text-xs-center" @click="calPointCop()">
          <span v-for="(itemKq, indexKq) in kqThietBi" class="text-xs-center">
            <input type="radio" name="result7_6" class="check_radio" :id="'result_7_6' + (indexKq)" :value="itemKq['value']" style="margin: 0 5px 0 0" v-model="thietBiKiemTra['resultTest'][5]['result']">
            <label class="label-radio" :for="'result_7_6' + (indexKq)" style="margin: 0" v-html="itemKq['text']"></label>
          </span>
        </td>
      </tr>

      <!-- ================================ -->

    </tbody>
  </table>
  <v-layout row wrap class="ml-0 pl-3">
    <v-flex xs12 sm2>
      <i style="font-weight: bold; font-size: 13px;">Ghi chú</i>
    </v-flex>
    <v-flex xs12 sm10>
      <v-text-field
        v-model="thietBiKiemTra['ghi_chu']"
      ></v-text-field>
    </v-flex>
    <v-flex xs12 sm2 class="pb-2 pt-2">
      <i style="font-weight: bold; font-size: 13px;">Kết luận:</i>
    </v-flex>
    <v-flex xs12 sm4 class="pb-2 pt-2">
      <#-- <input type="radio" name="ketluantb" id="ketluantb1" value="1" v-model="thietBiKiemTra['ketLuan']">
      <label class="mr-3" for="ketluantb1">Đạt</label>

      <input type="radio" name="ketluantb" id="ketluantb2" value="2" v-model="thietBiKiemTra['ketLuan']">
      <label for="ketluantb2">Không đạt</label> -->
      <span v-for="(itemKq, indexKq) in kqFullText" class="text-xs-center pr-2">
        <input type="radio" :name="thietBiKiemTra['ky_hieu'] + '_result'" class="check_radio" :id="thietBiKiemTra['ky_hieu'] + '_result_' + (indexKq + 1)" v-model="thietBiKiemTra['nd_result']" :value="itemKq['value']" style="margin: 0 5px 0 0">
        <label class="label-radio" :for="thietBiKiemTra['ky_hieu'] + '_result_' + (indexKq + 1)" style="margin: 0" v-html="itemKq['text']"></label>
      </span>
    </v-flex>
    <v-flex xs12 sm6 class="text-xs-right" class="pb-2 pt-2">
      <span style="font-weight: bold;">{{thietBiKiemTra['totalD']}}</span> Đ, <span style="font-weight: bold;">{{thietBiKiemTra['totalKD']}}</span> KĐ, <span style="font-weight: bold;">{{thietBiKiemTra['totalNA']}}</span> NA
    </v-flex>
    <v-flex xs12 sm2 class="pt-2">
      <i style="font-weight: bold; font-size: 13px;">Số tem kiểm tra:</i>
    </v-flex>
    <v-flex xs12 sm1>
      <v-text-field
        v-model="thietBiKiemTra['temp']"
      ></v-text-field>
    </v-flex>
  </v-layout>
  </div>
</template>