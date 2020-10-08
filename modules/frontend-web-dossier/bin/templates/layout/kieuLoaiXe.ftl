<v-layout row wrap class="ml-0 pl-2">
  <v-flex xs12 sm3>
    <label class="content-label">Đăng kiểm viên 1:&nbsp;</label>
  </v-flex>
  <v-flex xs12 sm9>
    <v-select
    class="my-0 py-0"
    :items="dangKiemVienItems"
    item-text="fullName"
    item-value="userId"
    v-model="kiemTraTinhPhuHop['dang_kiem_vien_1']"
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
    v-model="kiemTraTinhPhuHop['dang_kiem_vien_2']"
    ></v-select>
  </v-flex>

  <v-flex xs12 sm3>
    <label class="content-label">Số báo cáo đánh giá:&nbsp;</label>
  </v-flex>
  <v-flex xs12 sm9>
    <v-text-field
    class="my-0 py-0"
    v-model="kiemTraTinhPhuHop['copReportNo']"
    ></v-text-field>
  </v-flex>

  <v-flex xs12 sm3>
    <label class="content-label">Ngày kiểm tra (từ):&nbsp;</label>
  </v-flex>
  <v-flex xs12 sm9>
    <v-text-field
    class="my-0 py-0"
    v-model="kiemTraTinhPhuHop['copReportDateFrom']"
    ></v-text-field>
  </v-flex>

  <v-flex xs12 sm3>
    <label class="content-label">Đến ngày:&nbsp;</label>
  </v-flex>
  <v-flex xs12 sm9>
    <v-text-field
    class="my-0 py-0"
    v-model="kiemTraTinhPhuHop['copReportDateTo']"
    ></v-text-field>
  </v-flex>

  <v-flex xs12 sm3>
    <label class="content-label">Loại sản phẩm:&nbsp;</label>
  </v-flex>
  <v-flex xs12 sm3>
    <v-text-field
    class="my-0 py-0"
    v-model="kiemTraTinhPhuHop['type_text']"
    ></v-text-field>
  </v-flex>

  <v-flex xs12 sm3>
    <label class="content-label">Số giấy chứng nhận:&nbsp;</label>
  </v-flex>
  <v-flex xs12 sm3>
    <v-text-field
    class="my-0 py-0"
    v-model="kiemTraTinhPhuHop['cerNo_text']"
    ></v-text-field>
  </v-flex>

  <template v-for="(item, index) in kiemTraTinhPhuHop['dsXePopUpKieuLoai']" :key="'dsXePopUpKieuLoai' + index">
    <v-flex xs12 sm1 class="pt-2">
      <label class="content-label">Xe thứ {{index + 1}}:&nbsp;</label>
    </v-flex>
    <v-flex xs12 sm1 class="pt-2">
      <label class="content-label">Số khung:&nbsp;</label>
    </v-flex>
    <v-flex xs12 sm3>
      <v-text-field
      class="my-0 py-0"
      v-model="item['so_khung']"
      ></v-text-field>
    </v-flex>
    <v-flex xs12 sm7>
    </v-flex>

    <v-flex xs12 sm1>
    </v-flex>
    <v-flex xs12 sm1 class="pt-2">
      <label class="content-label">Số động cơ:&nbsp;</label>
    </v-flex>
    <v-flex xs12 sm3>
      <v-text-field
      class="my-0 py-0"
      v-model="item['so_dong_co']"
      ></v-text-field>
    </v-flex>
    <v-flex xs12 sm7>
    </v-flex>
  </template>

  <v-flex xs12 sm12>
    <table style="width: 100%;" border="1" class="ftable">
      <thead>
        <tr style="background: #d9d8d8;">
         <th class="text-xs-center py-1">TT</th>
         <th class="text-xs-center py-1">Hạng mục kiểm tra</th>
         <th class="text-xs-center py-1">Đối chiếu với hồ sơ chứng nhận</th>
         <th class="text-xs-center py-1">Nội dung không phù hợp</th>
       </tr>
     </thead>
     <tbody>
       <tr id="gen_4_2_1_1" v-for="(item, index) in kiemTraTinhPhuHop['chiTietKieuLoai']">
        <td class="text-xs-center">
          {{index + 1}}
        </td>
        <td class="text-xs-center">{{item['hangMuc']}}</td>
        <td class="text-xs-center">
          <v-select
            class="my-0 py-0"
            item-text="text"
            item-value="value"
            :items="tinhPhuHopItems"
            v-model="item['doiChieuGCN']"
          ></v-select>
        </td>
        <td class="text-xs-center">
          <v-text-field
            class="py-0 my-0"
            v-model="item['noiDungKoPhuHop']"
          ></v-text-field>
        </td>
      </tr>
    </tbody>
  </table>
  </v-flex>

  <v-flex xs12 sm2 class="pt-2">
      <i style="font-weight: bold; font-size: 13px;">Ghi chú</i>
    </v-flex>
    <v-flex xs12 sm10>
      <v-text-field
        class="my-0 py-0"
        v-model="kiemTraTinhPhuHop['ghi_chu']"
      ></v-text-field>
    </v-flex>
    <v-flex xs12 sm2 class="pb-2 pt-2">
      <i style="font-weight: bold; font-size: 13px;">Kết luận:</i>
    </v-flex>
    <v-flex xs12 sm10 class="pb-2 pt-2">

      <span v-for="(itemKq, indexKq) in kqFullText" class="text-xs-center pr-2" :key="'kl_mau1' + indexKq">
        <input type="radio" name="kiem_tra_phu_hop_kl" class="check_radio" :id="'kiem_tra_phu_hop_kl_result_' + (indexKq + 1)" v-model="kiemTraTinhPhuHop['nd_result']" :value="itemKq['value']" style="margin: 0 5px 0 0">
        <label class="label-radio" :for="'kiem_tra_phu_hop_kl_result_' + (indexKq + 1)" style="margin: 0" v-html="itemKq['text']"></label>
      </span>
    </v-flex>

    <#-- <v-flex xs12 sm2 class="pt-2">
      <i style="font-weight: bold; font-size: 13px;">Số tem kiểm tra:</i>
    </v-flex>
    <v-flex xs12 sm1>
      <v-text-field
        class="my-0 py-0"
        v-model="kiemTraTinhPhuHop['temp']"
      ></v-text-field>
    </v-flex> -->
</v-layout>