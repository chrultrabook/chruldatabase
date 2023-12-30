use diesel::Queryable;

#[derive(Queryable)]
#[diesel(table_name = device)]
struct Device {
  id: u32,
  name: String,
  arch_id: u32,
  brand_id: u32
}
